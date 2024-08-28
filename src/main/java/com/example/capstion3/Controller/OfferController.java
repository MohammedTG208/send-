package com.example.capstion3.Controller;

import com.example.capstion3.Model.Offer;
import com.example.capstion3.Service.OfferService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/offer")
@RestController
public class OfferController {
    private final OfferService offerService;

    @GetMapping("/get")
    public ResponseEntity getAllOffers(){
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @PostMapping("/add")
    public ResponseEntity addOffer(@Valid @RequestBody Offer offer){
        offerService.addNewOffer(offer);
        return ResponseEntity.status(200).body("offer added successfully");
    }

    @PutMapping("/update/{offerId}")
    public ResponseEntity updateOffer(@Valid @RequestBody Offer offer, @PathVariable Integer offerId){
        offerService.updateOffer(offer, offerId);
        return ResponseEntity.status(200).body("offer updated successfully");
    }

    @DeleteMapping("/delete/{offerId}")
    public ResponseEntity deleteOffer(@PathVariable Integer offerId){
        offerService.deleteOffer(offerId);
        return ResponseEntity.status(200).body("offer deleted successfully");
    }
}
