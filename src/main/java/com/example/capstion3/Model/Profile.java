package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Profile {
    @Id
    private Integer id;
    @NotEmpty(message = "name can not be null")
    @Column(columnDefinition = "varchar(35) not null")
    private String name;
    @Email(message = "enter valid email")
    @Column(columnDefinition = "varchar(50) not null")
    private String email;
    @NotEmpty(message = "phoneNumber can not be null")
    @Size(max = 10,message = "phoneNumber 10 numbers only")
    @Column(columnDefinition = "varchar(10) not null")
    private  String phoneNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
}
