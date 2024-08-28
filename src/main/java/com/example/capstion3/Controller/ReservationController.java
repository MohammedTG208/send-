package com.example.capstion3.Controller;


import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/get")

    public ResponseEntity getReservation() {
        return ResponseEntity.status(200).body(reservationService.getAllReservations());
    }

    public ResponseEntity addReservation(@Valid@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
        return ResponseEntity.status(200).body("reservation added");

    }






    @PutMapping("/update/{id}")
    public ResponseEntity updateReservation(@PathVariable Integer id, @Valid@RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return ResponseEntity.status(200).body("Reservation updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.status(200).body("Reservation deleted");
    }
}


