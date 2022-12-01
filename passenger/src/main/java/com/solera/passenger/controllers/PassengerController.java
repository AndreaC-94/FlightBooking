package com.solera.passenger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.passenger.entities.Passenger;
import com.solera.passenger.services.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    
    @Autowired
    private PassengerService passengerService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<String> createPassenger(@RequestBody Passenger passenger){
        try{
            String msg = passengerService.createPassenger(passenger);
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    @RequestMapping("/getPassenger")
    public ResponseEntity<?> getPassenger(@RequestBody String id){
        try{
            Passenger pass = passengerService.getPassenger(id);
            return new ResponseEntity<Passenger>(pass, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
