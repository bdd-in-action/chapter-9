package com.wakaleo.bddinaction.chapter9.flightstatus.service;

import com.wakaleo.bddinaction.chapter9.flightstatus.model.Flight;

public interface FlightService {
    Flight findByFlightNumber(String flightNumber);
}
