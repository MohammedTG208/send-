package com.example.capstion3.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @NotEmpty(message = "academic specialization can not be null")
    @Column(columnDefinition = "varchar(80) not null")
   private String academic_specialization;
    @NotEmpty(message = "can not be null")
    @Column(columnDefinition = "varchar(80) not null")
   private String professional_certifications;
    @NotEmpty(message = "profile summary can not be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String profile_summary;
    @Positive(message = "enter valid value for experience years")
    private int  experience_years ;
    @AssertFalse
    @Column(columnDefinition = "boolean DEFAULT false")
    private  boolean status ;

    @OneToOne
    @MapsId
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant")
    private Set<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultant")
    private Set<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultant")
    private Set<Consultant_Service> consultant_services;

}
