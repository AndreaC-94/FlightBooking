package com.solera.passenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.passenger.entities.Passenger;
import com.solera.passenger.repositories.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public String createPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
        return "The passenger has been saved correctly!";
    }

    public Passenger getPassenger(String id) throws Exception {
        for (Passenger pass : PassengerRepository.passengers) {
            if(pass.getId().equals(id)){
                return pass;
            }
        }
        throw new Exception("No passenger with such id have been found, check the id and try again.");
    }
    

}
