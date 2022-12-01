package com.solera.booking.services;

import java.net.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.solera.booking.common.Flight;
import com.solera.booking.common.Passenger;
import com.solera.booking.common.PrenotationRequest;
import com.solera.booking.entities.Prenotation;
import com.solera.booking.repositories.PrenotationRepository;

@Service
public class PrenotationService {
    
    @Autowired
    private PrenotationRepository prenotationRepository;
    @Autowired
    private RestTemplate restTemplate;
    
    public String createPrenotation(PrenotationRequest prenotation) {
        Flight flight = restTemplate
        .getForObject("http://localhost:8081/flight/getFlight/" + prenotation.getFlightId(), Flight.class);
        Passenger passenger = restTemplate
        .getForObject("http://localhost:8082/passenger/getPassenger/" + prenotation.getPassengerId(), Passenger.class);

        Prenotation prenotationSave = new Prenotation(flight, passenger);
        prenotationRepository.save(prenotationSave);
        return prenotationSave.getBookId();
    }

    //restTemplate.postForObject("url", "requested body", response state);
}
