package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Consultant_Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "request_date can not be null")
    @Column(columnDefinition = "date not null")
    private LocalDateTime request_date;
    @NotEmpty(message = "description is requirement")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;
    @Column(columnDefinition = "enum('pending','approved','rejected') DEFAULT 'pending'")
    private String Status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant_request")
    private  Set<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultant_request")
    private Set<Reservation> reservations;

    @ManyToOne
    @JsonIgnore
    private User user;
}
