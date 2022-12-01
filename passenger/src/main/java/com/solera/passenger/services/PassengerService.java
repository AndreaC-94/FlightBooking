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
        Passenger passenger2 = new Passenger(passenger.getFirstName(), passenger.getLastName(), passenger.getNationality(),
        passenger.getDocuments(), passenger.getAge(), passenger.isHasLuggage());
        passengerRepository.save(passenger2);
        return passenger2.getId();
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
