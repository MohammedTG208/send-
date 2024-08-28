package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Offer;
import com.example.capstion3.Repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        if (offerRepository.findAll().isEmpty()){
            throw new APIException("offer not found in DataBase");
        }else {
            return offerRepository.findAll();
        }
    }

    public void addNewOffer(Offer offer) {
        offerRepository.save(offer);
    }

    public void updateOffer(Offer offer,Integer id) {
        if (offerRepository.findOfferById(id)==null){
            throw new APIException("offer not found in to updated");
        }else {
            Offer updatedOffer = offerRepository.findOfferById(id);
            updatedOffer.setDescription(offer.getDescription());
            updatedOffer.setPrice(offer.getPrice());
            offerRepository.save(updatedOffer);
        }
    }

    public void deleteOffer(Integer id) {
        if (offerRepository.findOfferById(id)==null){
            throw new APIException("offer not found in to deleted");
        }else {
            offerRepository.deleteById(id);
        }
    }


}
