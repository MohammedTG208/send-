package com.example.capstion3.Controller;


import com.example.capstion3.DTO.ProfileDTO;
import com.example.capstion3.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;


    @GetMapping("/get")
    public ResponseEntity getProfile() {
        return ResponseEntity.status(200).body(profileService.getAllProfiles());

    }
    @PostMapping("/add")
    public ResponseEntity addProfile(@Valid @RequestBody ProfileDTO profileDTO) {
        profileService.addProfile(profileDTO);
        return ResponseEntity.status(200).body("Profile added successfully");
    }
    @PutMapping("/update/")
    public ResponseEntity updateProfile(@Valid @RequestBody ProfileDTO profileDTO) {
        profileService.updateProfile(profileDTO);
        return ResponseEntity.status(200).body("Profile updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProfile(@PathVariable Integer id) {
        profileService.deleteProfile(id);
        return ResponseEntity.status(200).body("Profile deleted successfully");
    }
}
