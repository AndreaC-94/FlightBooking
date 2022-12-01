package com.solera.booking.common;

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
}
