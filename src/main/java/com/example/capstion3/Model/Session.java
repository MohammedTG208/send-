package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date not null")
   private LocalDateTime session_date;
    @Positive(message = "enter valid value for duration minutes")
    @Column(columnDefinition = "int not null")
    private int  duration_minutes ;
    @Column(columnDefinition = "varchar(200) not null")
    @NotEmpty(message = "notes can not be empty")
    private String notes;
    @Positive(message = "enter valid seat")
    @Column(columnDefinition = "int not null")
    private int seat;
    @NotEmpty(message = "session link can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String session_link;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
    private Set<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
    private Set<User> user;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "session")
    private Reservation reservation;

}
