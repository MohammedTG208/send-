package com.example.capstion3.Service;


import com.example.capstion3.API.APIException;
import com.example.capstion3.DTO.SessionDTO;
import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Model.Session;
import com.example.capstion3.Repository.ReservationRepository;
import com.example.capstion3.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final ReservationRepository reservationRepository;

    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }



//######################
    public void addSession(SessionDTO sessionDTO ,Integer consultantId) {
        Reservation reservation=reservationRepository.findReservationById(sessionDTO.getReservation_id());
        if (reservation==null) {
            throw new APIException("can not add session because reservation not found");
        }else {
            if (reservation.getConsultantService().getConsultant().getId()==consultantId){
                Session session=new Session(null,sessionDTO.getSession_date(), sessionDTO.getDuration_minutes(), sessionDTO.getNotes(),sessionDTO.getSeat(),sessionDTO.getSession_link(),null,null,null);
                sessionRepository.save(session);
            }
        }
    }


    public void updateSession(Integer id, Session session) {
        Session session1 = sessionRepository.findSessionById(id);
        if (session1 == null) {
            throw new APIException("Session not found");
        }

        session1.setSession_date(session.getSession_date());
        session1.setNotes(session.getNotes());
        session1.setDuration_minutes(session.getDuration_minutes());
        sessionRepository.save(session1);
    }

    public void deleteSession(Integer id) {
        Session session = sessionRepository.findSessionById(id);
        if (session == null) {
            throw new APIException("Session not found");
        }
        sessionRepository.delete(session);

    }
}
