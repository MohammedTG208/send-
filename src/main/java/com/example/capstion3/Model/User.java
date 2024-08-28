package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Check(constraints = "role='customer' or role='admin'")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null unique ")
    private String username;
    @Column(columnDefinition = "int not null")
    private String password;

    @Column(columnDefinition = "varchar(30) not null unique ")
    @Email
    private String email;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(30) not null unique ")
    private  String phoneNumber;

    @Column(columnDefinition ="varchar(5)")
    @Pattern(regexp = "(customer|admin)+$")
    private String role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Profile profile;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Subscription subscription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Consultant_Request> consultantRequests;

    @ManyToOne
    @JsonIgnore
    private Reservation reservation;

    @ManyToOne
    @JsonIgnore
    private Session session;

}
