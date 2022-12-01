package com.solera.booking.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.booking.entities.Prenotation;

@Component
public class PrenotationRepository {
    
    public static List<Prenotation> prenotations;

    public void save(Prenotation prenotation){
        prenotations.add(prenotation);
    }
}
