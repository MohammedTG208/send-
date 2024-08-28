package com.example.capstion3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsultantDTO {
    private Integer category_id;
    @NotEmpty(message = "academic specialization can not be null")
    private String academic_specialization;
    @NotEmpty(message = "can not be null")
    private String professional_certifications;
    @NotEmpty(message = "profile summary can not be null")
    private String profile_summary;
    @Positive(message = "enter valid value for experience years")
    private int  experience_years ;
    @AssertFalse
    private boolean status ;

}
