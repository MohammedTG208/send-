package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Subscription {
    @Id
    private Integer id;
    @Column(columnDefinition ="varchar(7) not null")
    @Pattern(regexp = "(subscribe)+$")
    private String subscriptionType;
    @Email(message = "Enter valid email")
    @Column(columnDefinition = "varchar(35) not null")
    private String email_address;
    @NotEmpty(message = "start_Date can not be null")
    @Column(columnDefinition = "date")
    private LocalDate start_date;
    @NotEmpty(message = "end_Date can not be null")
    @Column(columnDefinition = "date not null")
    private LocalDate end_date;

    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
}
