package com.solera.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
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
        Flight flight = restTemplate.getForObject("http://localhost:8081/flight/getFlight",Flight.class , prenotation.getFlightid());
        System.out.println("Your flight is: " + flight.toString());
        return null;
    }

    //restTemplate.postForObject("url", "requested body", response state);
}
