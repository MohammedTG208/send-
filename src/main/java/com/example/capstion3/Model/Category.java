package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "category name can not be null")
    @Column(columnDefinition = "enum('medicine','law','engineering') unique")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "category")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private  Consultant consultant;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private  Set<Consultant_Service> consultant_services;
}
