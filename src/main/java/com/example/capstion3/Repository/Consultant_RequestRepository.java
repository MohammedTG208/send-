package com.example.capstion3.Repository;

import com.example.capstion3.Model.Consultant_Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Consultant_RequestRepository extends JpaRepository<Consultant_Request, Integer> {
    @Query("select cRequest from Consultant_Request cRequest where cRequest.id=?1")
    Consultant_Request findConsultant_RequestById(Integer id);
}
