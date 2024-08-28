package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant_Request;
import com.example.capstion3.Model.Offer;
import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Model.User;
import com.example.capstion3.Repository.Consultant_RequestRepository;
import com.example.capstion3.Repository.OfferRepository;
import com.example.capstion3.Repository.ReservationRepository;
import com.example.capstion3.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Consultant_RequestService {
    private final Consultant_RequestRepository cRrepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final ReservationRepository reservationRepository;

    public List<Consultant_Request> getAllConsultant_Requests() {
        if (cRrepository.findAll().isEmpty()) {
            throw new APIException("No consultant requests found");
        }else {
            return cRrepository.findAll();
        }
    }

    public void addNewConsultantRequest( Integer id,Consultant_Request consultant_request ) {
        User user=userRepository.findUserById(id);
        if (consultant_request == null) {
            throw new APIException("Consultant request not found");
        }
        consultant_request.setUser(user);
        cRrepository.save(consultant_request);

    }

    public void deleteConsultantRequest(Integer id) {
        if (cRrepository.findConsultant_RequestById(id)==null){
            throw new APIException("Consultant request not found to delete");
        }else {
            cRrepository.deleteById(id);
        }
    }

    public void updateConsultantRequest(Consultant_Request consultant_request,Integer id) {
        if (cRrepository.findConsultant_RequestById(id)==null){
            throw new APIException("Consultant request not found to update");
        }else {
            Consultant_Request updatedConsultantRequest = cRrepository.findConsultant_RequestById(id);
            updatedConsultantRequest.setRequest_date(consultant_request.getRequest_date());
            updatedConsultantRequest.setDescription(consultant_request.getDescription());
            updatedConsultantRequest.setStatus(consultant_request.getStatus());
            cRrepository.save(updatedConsultantRequest);
        }
    }
//#####################################
    public void approvedService(Integer uId,Integer offerId,Integer cqId){
        Consultant_Request consultantRequest=cRrepository.findConsultant_RequestById(uId);
       User user=userRepository.findUserById(uId);
        Offer offer=offerRepository.findOfferById(offerId);
        if (consultantRequest==null||user==null||offer==null){
            throw new APIException("Consultant request not found to approve");
        }else {
            offer.setApproved(true);
            offerRepository.save(offer);
            Reservation reservation=new Reservation(null,consultantRequest.getRequest_date(),"pending",consultantRequest,null,null);
            reservationRepository.save(reservation);
        }
    }
}
