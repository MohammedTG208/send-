package com.example.capstion3.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class SessionDTO {

    private Integer reservation_id;
    private LocalDateTime session_date;
    @Positive(message = "enter valid value for duration minutes")
    private int  duration_minutes ;
    @NotEmpty(message = "notes can not be empty")
    private String notes;
    @Positive(message = "enter valid seat")
    private int seat;
    @NotEmpty(message = "session link can not be null")
    private String session_link;
}
