package com.bobcurrie.flightcheckin.integration.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter

public class Flight {

    private Long id;
    private String flightNumber;
    private String operatingAirlines;
    private String arrivalCity;
    private String departureCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;

}
