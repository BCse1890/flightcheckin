package com.bobcurrie.flightcheckin.integration.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Passenger  {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;

}
