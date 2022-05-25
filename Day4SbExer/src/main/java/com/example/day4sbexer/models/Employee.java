package com.example.day4sbexer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;


@AllArgsConstructor @Data
public class Employee {

    @NotNull
    @Size(min = 2 , message = "ID must be more than 2 char")
    private String ID ;

    @NotNull
    @Size(min = 4 , message = "Name must be more than 4 char")
    private String name;

    @NotNull
    @Positive(message = "age has to be num")

    private String age ;

    @AssertFalse
    private Boolean onLeave;

    @NotNull
    @Positive(message = "Year has to be num")
    // valid year
    private Integer employmentYear;

    @NotNull
    @Positive(message = "annualLeave has to be num")
    private Integer annualLeave;



}
