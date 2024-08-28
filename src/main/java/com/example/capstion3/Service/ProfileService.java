package com.example.capstion3.Service;



import com.example.capstion3.API.APIException;
import com.example.capstion3.DTO.ProfileDTO;
import com.example.capstion3.Model.Profile;
import com.example.capstion3.Model.User;
import com.example.capstion3.Repository.ProfileRepository;
import com.example.capstion3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public void addProfile(ProfileDTO profileDTO) {
        User user=userRepository.findUserById(profileDTO.getUser_id());
        if (user==null){
            throw new APIException("User not found");
        }else {
            Profile profile=new Profile(null,profileDTO.getName(),profileDTO.getEmail(),profileDTO.getPhoneNumber(),user);
            profileRepository.save(profile);
        }
    }
    public void updateProfile(ProfileDTO profileDTO) {
        if (profileRepository.findProfileById(profileDTO.getUser_id())==null){
            throw new APIException("profile not found");
        }else {
            Profile profile1=profileRepository.findProfileById(profileDTO.getUser_id());
        profile1.setName(profileDTO.getName());
        profile1.setEmail(profileDTO.getEmail());
        profile1.setPhoneNumber(profileDTO.getPhoneNumber());
        profileRepository.save(profile1);
        }
    }
    public void deleteProfile(Integer id) {
        Profile profile = profileRepository.findProfileById(id);
        if(profile == null) {
            throw new APIException("Profile not found");
        }
        profileRepository.delete(profile);
    }
}
