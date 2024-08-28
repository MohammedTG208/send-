package com.example.capstion3.Controller;


import com.example.capstion3.DTO.ConsultantDTO;
import com.example.capstion3.Service.ConsultantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consultant")
@RequiredArgsConstructor
public class ConsultantController {
    private final ConsultantService consultantService;


    @GetMapping("/get")
    public ResponseEntity getAllConsultant() {
        return ResponseEntity.status(200).body(consultantService.getAllConsultant());
    }

    @PostMapping("/add")
    public ResponseEntity addConsultant(@Valid @RequestBody ConsultantDTO consultantDTO) {
        consultantService.addConsultant(consultantDTO);
        return ResponseEntity.status(200).body("Consultant added");
    }
    @PutMapping("/update")
    public ResponseEntity updateConsultant(@Valid@RequestBody ConsultantDTO consultantDTO) {
        consultantService.updateConsultant(consultantDTO);
        return ResponseEntity.status(200).body("Consultant updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCConsultant(@PathVariable Integer id) {
        consultantService.deleteConsultant(id);
        return ResponseEntity.status(200).body("Consultant deleted");
    }

    @GetMapping("/get/by/category/{catId}")
    public ResponseEntity getConsultantByCategory(@PathVariable Integer catId) {
        return ResponseEntity.status(200).body(consultantService.getConsultantByCategory(catId));
    }
}


