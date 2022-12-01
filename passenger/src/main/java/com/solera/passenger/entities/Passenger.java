package com.solera.passenger.entities;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Passenger {
    
    private String id;
    private String firstName;
    private String lastName;
    private String nationality; //Might be better as an enum(?)
    private String documents; //Nif or Passport, might be changed to have a better validation
    private int age;
    private boolean hasLuggage;

    public Passenger(String firstName, String lastName, String nationality, String documents, int age,
            boolean hasLuggage) {
        this.id = UUID.randomUUID().toString().substring(0,9);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.documents = documents;
        this.age = age;
        this.hasLuggage = hasLuggage;
    }
}
