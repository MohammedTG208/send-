package com.example.capstion3.Controller;



import com.example.capstion3.DTO.SubscriptionDTO;
import com.example.capstion3.Model.Subscription;
import com.example.capstion3.Service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("/get")
    public ResponseEntity getSubscription() {
        return ResponseEntity.status(200).body(subscriptionService.getAllSubscriptions());
    }

    @PostMapping("/add")
    public ResponseEntity addSubscription(@Valid @RequestBody SubscriptionDTO subscriptionDTO) {
        subscriptionService.addSubscription(subscriptionDTO);
        return ResponseEntity.status(200).body("Subscription added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity updateSubscription( @Valid @RequestBody SubscriptionDTO subscriptionDTO) {
        subscriptionService.updateSubscription(subscriptionDTO);
        return ResponseEntity.status(200).body("Subscription updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSubscription(@PathVariable Integer id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.status(200).body("Subscription deleted successfully");
    }

    @GetMapping("/get/{uId}")
    public ResponseEntity searchSubscription(@PathVariable Integer uId) {
        List<Subscription> subscriptions = subscriptionService.searchSubscription(uId);
        return ResponseEntity.status(200).body(subscriptions);

    }
}

