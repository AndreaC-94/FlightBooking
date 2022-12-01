package com.solera.booking.services;

import java.net.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.solera.booking.common.Flight;
import com.solera.booking.common.PrenotationRequest;
import com.solera.booking.repositories.PrenotationRepository;

@Service
public class PrenotationService {
    
    @Autowired
    private PrenotationRepository prenotationRepository;
    @Autowired
    private RestTemplate restTemplate;
    
    public String createPrenotation(PrenotationRequest prenotation) {
        System.out.println("before the call! flight id: " + prenotation.getFlightId());

        Flight flight = restTemplate
        .getForObject("http://localhost:8081/flight/getFlight/" + prenotation.getFlightId(), Flight.class);

        System.out.println("Your flight is: " + flight.getFlightId());
        return null;
    }

    //restTemplate.postForObject("url", "requested body", response state);
}
