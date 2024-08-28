package com.example.capstion3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Positive(message = "Enter valid value for rating")
    @Column(columnDefinition = "int not null check(rating_score>=5)")
    private  int  rating_score;
    @NotEmpty(message = "review not null")
    @Column(columnDefinition = "varchar(200) not null")
    private String review;

    @ManyToOne
    @JsonIgnore
    private Consultant consultant;

    @ManyToOne
    @JsonIgnore
    private Session session;


}
