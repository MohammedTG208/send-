package com.example.capstion3.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDTO {
    private Integer user_id;
    @Pattern(regexp = "(year|monthly)+$")
    private String subscription_type;
    @Email(message = "enter valid email")
    private String email_address;
    @NotEmpty(message = "Start_Date can not be null")
    private LocalDate start_date;
    @NotEmpty(message = "end_Date can not be null")
    private LocalDate end_date;
}
