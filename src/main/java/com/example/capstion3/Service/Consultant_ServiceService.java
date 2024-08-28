package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant;
import com.example.capstion3.Model.Consultant_Service;
import com.example.capstion3.Model.User;
import com.example.capstion3.Repository.ConsultantRepository;
import com.example.capstion3.Repository.Consultant_ServiceRepository;
import com.example.capstion3.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class Consultant_ServiceService {
    private final Consultant_ServiceRepository consultant_ServiceRepository;
    private final ConsultantRepository consultantRepository;
    private final UserRepository userRepository;

//############################3
    public Map<String, List<Consultant_Service>> getAllConsultantService(Integer uId) {
        List<Consultant_Service> services = consultant_ServiceRepository.findAll();
        User user=userRepository.findUserById(uId);
        if (services.isEmpty()) {
            throw new APIException("Consultant_Service is Empty");
        } else if (user.getSubscription().getSubscriptionType().equalsIgnoreCase("subscribe")) {
        Map<String, List<Consultant_Service>> result = new HashMap<>();
        result.put("You have 15% discount", services);
        return result;
        }else {
            Map<String, List<Consultant_Service>> result = new HashMap<>();
            result.put("You dont have subscribe", services);
            return result;
        }

    }


    //    ##########
    public void addNewConsultantService(Consultant_Service consultant_Service,Integer cId)  {
        if (consultantRepository.findConsultantById(cId)==null){
            throw new APIException("Consultant is not found");
        }else {
            Consultant consultant=consultantRepository.findConsultantById(cId);
            if (consultant.isStatus()){
            consultant_ServiceRepository.save(consultant_Service);
            }else {
                throw new APIException("You can not add");
            }
        }
    }

    public void updateConsultantService(Consultant_Service consultant_Service,Integer id)  {
        if (consultant_ServiceRepository.findConsultant_ServiceById(id)==null){
            throw new APIException("not found by this id to update");
        }else {
            Consultant_Service updateConsultant_Service = consultant_ServiceRepository.findConsultant_ServiceById(id);
            updateConsultant_Service.setDescription(consultant_Service.getDescription());
            updateConsultant_Service.setPrice(consultant_Service.getPrice());
            consultant_ServiceRepository.save(updateConsultant_Service);
        }
    }

    public void deleteConsultantService(Integer id)  {
        if (consultant_ServiceRepository.findConsultant_ServiceById(id)==null){
            throw new APIException("not found by this id to delete");
        }else {
            consultant_ServiceRepository.deleteById(id);
        }
    }
//    ###################
    public List getByPrice(Integer price)  {
        for (int i=0; i<consultant_ServiceRepository.findAll().size();)
    }
}
