package com.example.capstion3.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfileDTO {
    private Integer user_id;
    @NotEmpty(message = "name can not be null")
    private String name;
    @Email(message = "enter valid email")
    private String email;
    @NotEmpty(message = "phoneNumber can not be null")
    private  String phoneNumber;
}
