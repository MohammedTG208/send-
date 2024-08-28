package com.example.capstion3.Controller;

import com.example.capstion3.Model.Rating;
import com.example.capstion3.Service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;



    @GetMapping("/get")
    public ResponseEntity getAllRating() {
        return ResponseEntity.status(200).body(ratingService.getAllRating());
    }

    @PostMapping("/add/{cId}")
    public ResponseEntity addRating(@Valid @RequestBody Rating rating,@PathVariable int cId) {
        ratingService.addRating(rating,cId);
        return ResponseEntity.status(200).body("Rating added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateRating(@PathVariable Integer id, @Valid@RequestBody Rating rating) {
        ratingService.updateRating(id, rating);
        return ResponseEntity.status(200).body("Rating updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRating(@PathVariable Integer id) {
        ratingService.deleteRating(id);
        return ResponseEntity.status(200).body("Rating deleted");
    }
}
