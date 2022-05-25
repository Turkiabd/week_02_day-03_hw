package com.example.day4sbexer.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Ride {

// range w num and size no strings

    @NotNull
    @Size(min = 3 , message = "ID must be more than 2 char")
    private String rideID;

    @NotNull
    @Size(min = 4 , message = "Name must be more than 4 char")
    private String rideName;

    @NotNull
    //@Pattern("rollercoaster|thriller|water")
    @Pattern(regexp = "(rollercoaster|thriller|water)")
    private String rideType;

    @NotNull
    @Positive(message = "it must be number")
    private  Integer tickets;

    @NotNull
    @Positive(message = "it must be number")
    private Integer price ;



}
