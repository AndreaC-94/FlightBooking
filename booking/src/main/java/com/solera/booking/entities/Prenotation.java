package com.solera.booking.entities;

import java.util.UUID;

import com.solera.booking.common.Flight;
import com.solera.booking.common.Passenger;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class Prenotation {
    private String bookId;
    private Flight flight;
    private Passenger passenger;
    private int finalePrice;

    public Prenotation(Flight flight, Passenger passenger) {
        this.bookId = UUID.randomUUID().toString().substring(0,9);
        this.flight = flight;
        this.passenger = passenger;
        int luggageCost = passenger.isHasLuggage() ? 25:0;
        int ageCost = 0;
        if(passenger.getAge() > 9) ageCost = 20;
        else ageCost = passenger.getAge() < 2 ? 0:10;
        this.finalePrice = flight.getBasePrice() + luggageCost + ageCost;
    }
}
