package com.example.capstion3.Service;


import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant;
import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Model.Session;
import com.example.capstion3.Model.User;
import com.example.capstion3.Repository.ConsultantRepository;
import com.example.capstion3.Repository.ReservationRepository;
import com.example.capstion3.Repository.SessionRepository;
import com.example.capstion3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ConsultantRepository consultantRepository;
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user){
        User u = userRepository.findUserById(id);
        if(u == null){
            throw new APIException("User not found");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setRole(user.getRole());
        userRepository.save(u);
    }
    public void deleteUser(Integer id){
        User u = userRepository.findUserById(id);
        if(u == null){
            throw new APIException("User not found");
        }
        userRepository.delete(u);
    }
//    #######
    public void adminAprovedConsultant(Integer id,Integer cId){
        User u = userRepository.findUserById(id);
        if (u==null){
            throw new APIException("User not found");
        }else {
            if (u.getRole().equalsIgnoreCase("admin")) {
                if (consultantRepository.findConsultantById(cId) == null) {
                    throw new APIException("Consultant not found");
                }else {
                    Consultant consultant = consultantRepository.findConsultantById(cId);
                    consultant.setStatus(true);
                    consultantRepository.save(consultant);
                }
            }
        }
    }
//    ==============
    public void assignUserToReservation(Integer uid,Integer rId){
        User u = userRepository.findUserById(uid);
        Reservation r=reservationRepository.findReservationById(rId);
        if (u==null||r==null){
            throw new APIException("can not assign user to reservation");
        }else {
            u.setReservation(r);
            userRepository.save(u);
        }
    }
//    ########################
    public void assignUserToSession(Integer uid,Integer sId){
        User u = userRepository.findUserById(uid);
        Session sess=sessionRepository.findSessionById(sId);
        if (u==null||sess==null){
            throw new APIException("can not assign user to session");
        }else {
            if (sess.getSession_date().isAfter(LocalDateTime.now())){
              throw new APIException("this session is not available");
            }else {
                if (sess.getSeat()!=0){
                    u.setSession(sess);
                    sess.setSeat(sess.getSeat()-1);
                    sessionRepository.save(sess);
                    userRepository.save(u);
                }else {
                    throw new APIException("no seat available for this session");
                }

            }
        }
    }


}
