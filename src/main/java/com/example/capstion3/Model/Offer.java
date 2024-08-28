package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "description can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String description;
    @Positive(message = "price can not be null")
    @Column(columnDefinition = "decimal(10,2) not null")
    private Double price;
    @Column(columnDefinition = "boolean DEFAULT false")
    private boolean Approved;


    @ManyToOne
    @JsonIgnore
    private  Consultant consultant;
    @ManyToOne
    private Consultant_Request consultant_request;
}
