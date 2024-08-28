package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date not null")
    private LocalDateTime reservation_date;
    @Pattern(regexp = "(pending|confirmed|cancelled)+$")
    @Column(columnDefinition = "enum('pending','confirmed','cancelled')")
    private String status;

    @ManyToOne
    @JsonIgnore
    private Consultant_Request consultant_request;

    @ManyToOne
    @JsonIgnore
    private Consultant_Service consultantService;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reservation")
    private Set<User> user;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Session session;


}
