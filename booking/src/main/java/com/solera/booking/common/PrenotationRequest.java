package com.solera.booking.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrenotationRequest {
    private String flightId;
    private String passengerId;
}
