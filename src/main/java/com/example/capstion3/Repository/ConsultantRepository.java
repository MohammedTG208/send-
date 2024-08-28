package com.example.capstion3.Repository;

import com.example.capstion3.Model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {

    Consultant findConsultantById(Integer id);
}
