package com.solera.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.booking.common.PrenotationRequest;
import com.solera.booking.services.PrenotationService;

@RestController
@RequestMapping("/booking")
public class PrenotationController {
    
    @Autowired
    private PrenotationService prenotationService;

    @PostMapping("/createPrenotation")
    public ResponseEntity<?> createPrenotation(@RequestBody PrenotationRequest prenotation){
        try{
            System.out.println("Controller, id: " +prenotation.getFlightId());
            String msg = prenotationService.createPrenotation(prenotation);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
