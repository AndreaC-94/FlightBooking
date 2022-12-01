package com.solera.passenger.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.passenger.entities.Passenger;

@Component
public class PassengerRepository {
    
    public static List<Passenger> passengers = new ArrayList<>();
    
    public void save(Passenger passenger){
        passengers.add(passenger);
    }
}
