package com.solera.booking.common;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Flight {

    private String flightId;
    private String companyName;
    private CityEnum origin;
    private CityEnum destination;
    private LocalDate date;
    private int seats;
    private boolean luggageAllowed;
    private List<CityEnum> scales;
    private int basePrice;
}
