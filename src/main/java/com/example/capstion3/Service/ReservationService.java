package com.example.capstion3.Service;


import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant;
import com.example.capstion3.Model.Consultant_Service;
import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Repository.ConsultantRepository;
import com.example.capstion3.Repository.Consultant_ServiceRepository;
import com.example.capstion3.Repository.ReservationRepository;
import com.example.capstion3.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    private final Consultant_ServiceRepository consultant_ServiceRepository;

    public List<Reservation> getAllReservations() {
        updateStatus();
        return reservationRepository.findAll();
    }

    public void addReservation(Reservation reservation,Integer consultantSId) {
        Consultant_Service consultantService=consultant_ServiceRepository.findConsultant_ServiceById(consultantSId);
        if ( consultantService== null) {
            throw new APIException("Consultant service not found");
        }else {
        reservation.setConsultantService(consultantService);
        reservationRepository.save(reservation);
        }
    }

    public void updateReservation(Integer id, Reservation reservation) {
        Reservation reservation1 = reservationRepository.findReservationById(id);
        if (reservation1 == null) {
            throw new APIException("Reservation not found");
        }

        reservation1.setReservation_date(reservation.getReservation_date());
        reservation1.setStatus(reservation.getStatus());
   reservationRepository.save(reservation1);

    }

    public void deleteReservation(Integer id) {
        Reservation reservation1 = reservationRepository.findReservationById(id);
        if (reservation1 == null) {
            throw new APIException("Reservation not found");
        }
        reservationRepository.delete(reservation1);
    }

//    ##############################
    public void updateStatus() {
        for (int i=0; i<reservationRepository.findAll().size(); i++) {
            if (reservationRepository.findReservationById(i).getReservation_date()== LocalDateTime.now()){
                Reservation reservation1 = reservationRepository.findReservationById(i);
                reservation1.setStatus("confirmed");
                reservationRepository.save(reservation1);
            }
        }
    }
}
