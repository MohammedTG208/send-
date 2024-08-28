package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Consultant_Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "description can not be null")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;
    @Positive(message = "Enter valid value for price")
    @Column(columnDefinition = "decimal(10,2) not null")
    private double price;

    @ManyToOne
    @JsonIgnore
    private  Category category;

    @ManyToOne
    @JsonIgnore
    private  Consultant consultant;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultantService")
    private Set<Reservation> reservations;

}
