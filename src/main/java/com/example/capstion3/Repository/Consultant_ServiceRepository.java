package com.example.capstion3.Repository;

import com.example.capstion3.Model.Consultant_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Consultant_ServiceRepository extends JpaRepository<Consultant_Service, Integer> {
    @Query("select cService from Consultant_Service cService where cService.id=?1")
    Consultant_Service findConsultant_ServiceById(Integer id);
}
