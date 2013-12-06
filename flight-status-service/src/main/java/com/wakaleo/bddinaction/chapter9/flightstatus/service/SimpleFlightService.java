package com.wakaleo.bddinaction.chapter9.flightstatus.service;

import com.wakaleo.bddinaction.chapter9.flightstatus.model.Flight;

public class SimpleFlightService implements FlightService {
    @Override
    public Flight findByFlightNumber(String flightNumber) {
        return new Flight(1,"FH-203","Sydney","Perth");
    }
}
