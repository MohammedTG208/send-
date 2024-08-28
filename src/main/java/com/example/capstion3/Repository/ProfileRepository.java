package com.example.capstion3.Repository;



import com.example.capstion3.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
Profile findProfileById(Integer id);
}
