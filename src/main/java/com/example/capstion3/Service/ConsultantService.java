package com.example.capstion3.Service;


import com.example.capstion3.API.APIException;
import com.example.capstion3.DTO.ConsultantDTO;
import com.example.capstion3.Model.Category;
import com.example.capstion3.Model.Consultant;
import com.example.capstion3.Model.User;
import com.example.capstion3.Repository.CategoryRepository;
import com.example.capstion3.Repository.ConsultantRepository;
import com.example.capstion3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultantService {

    private final ConsultantRepository consultantRepository;
    private final UserRepository UserRepository;
    private final CategoryRepository categoryRepository;


    public List<Consultant> getAllConsultant() {
        return consultantRepository.findAll();

    }

    public void addConsultant(ConsultantDTO consultantDTO) {
        Category category = categoryRepository.findCategoryById(consultantDTO.getCategory_id());
        if (category == null) {
            throw new APIException("Category not found");
        } else {
            Consultant consultant = new Consultant(null, consultantDTO.getAcademic_specialization(), consultantDTO.getProfessional_certifications(), consultantDTO.getProfile_summary(), consultantDTO.getExperience_years(), consultantDTO.isStatus(), category, null, null, null);
            consultantRepository.save(consultant);
        }
    }

    public void updateConsultant(ConsultantDTO consultantDTO) {
        Consultant consultant1 = consultantRepository.findConsultantById(consultantDTO.getCategory_id());
        if (consultant1 == null) {
            throw new APIException("Consultant not found");
        }
        consultant1.setExperience_years(consultantDTO.getExperience_years());
        consultant1.setAcademic_specialization(consultantDTO.getAcademic_specialization());
        consultant1.setProfessional_certifications(consultantDTO.getProfessional_certifications());
        consultant1.setProfile_summary(consultantDTO.getProfile_summary());
        consultant1.setStatus(consultantDTO.isStatus());
        consultantRepository.save(consultant1);

    }

    public void deleteConsultant(Integer id) {
        Consultant consultant = consultantRepository.findConsultantById(id);
        if (consultant == null) {
            throw new APIException("Consultant not found");
        }
        consultantRepository.deleteById(id);

    }

    //    #####################
    public List getConsultantByCategory(Integer catId) {
        List<Consultant> getByCategory = new ArrayList<>();
        for (int i = 0; i < consultantRepository.findAll().size(); i++) {
            if (consultantRepository.findConsultantById(i).getCategory().getId() == catId) {
                if (consultantRepository.findConsultantById(i).isStatus()) {
                    getByCategory.add(consultantRepository.findConsultantById(i));
                }
            }
        }
        return getByCategory;
    }

    //?########
    public Consultant getConsultINFOByID(Integer id) {
        Consultant consultant = consultantRepository.findConsultantById(id);
        if (consultant == null) {
            throw new APIException("Consultant not found");
        } else {
            if (consultant.isStatus()) {
                return consultant;
            }
            return null;
        }
    }
}
