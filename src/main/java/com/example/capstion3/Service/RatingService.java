package com.example.capstion3.Service;




import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant;
import com.example.capstion3.Model.Rating;
import com.example.capstion3.Model.Session;
import com.example.capstion3.Repository.ConsultantRepository;
import com.example.capstion3.Repository.RatingRepository;
import com.example.capstion3.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {


    private final RatingRepository ratingRepository;
    private final ConsultantRepository consultantRepository;
    private final SessionRepository sessionRepository;

    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    public void addRating(Rating rating,Integer consultantId) {
        Consultant consultant=consultantRepository.findConsultantById(consultantId);
        if (consultant==null) {
            throw new APIException("can not add rating because consultant not found");
        }else {
            rating.setConsultant(consultant);
            ratingRepository.save(rating);
        }
    }

    public void updateRating(Integer id, Rating rating) {
        Rating rating1 = ratingRepository.findRatingById(id);
        if (rating1 == null) {
            throw new APIException("Rating not found");


        }
        rating1.setRating_score(rating.getRating_score());
        rating1.setReview(rating.getReview());

        ratingRepository.save(rating1);

    }

    public void deleteRating(Integer id) {
        Rating rating = ratingRepository.findRatingById(id);
        if (rating == null) {
            throw new APIException("Rating not found");
        }
        ratingRepository.deleteById(id);

    }
//    ######################################
    public List getByRating(Integer rate) {
        List getAll=new ArrayList<>();
        for (Rating rating : ratingRepository.findAll()) {
            if (rating.getRating_score() == rate) {
                getAll.add(rating);
            }
        }
        if (getAll.isEmpty()){
            throw new APIException("not found by your choice");
        }
        return getAll;
    }
//##########################
    public void assignRatingToSession(Rating rating, Integer sessionId) {
        Session session = sessionRepository.findSessionById(sessionId);
        if (session == null) {
            throw new APIException("can not assign rating to session");
        } else {
            if (session.getSession_date().isBefore(LocalDateTime.now())) {
                throw new APIException("can not assign rating to session because session date is after now");
            } else {
                rating.setSession(session);
                ratingRepository.save(rating);

            }
        }
    }

}


