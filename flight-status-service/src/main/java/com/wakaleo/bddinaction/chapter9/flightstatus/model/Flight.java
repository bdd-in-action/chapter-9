package com.wakaleo.bddinaction.chapter9.flightstatus.model;

import java.io.Serializable;

public class Flight {

    private final long id;
    private final String flightNumber;
    private final String departure;
    private final String destination;

    public Flight(long id, String flightNumber, String departure, String destination) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
    }

    public long getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }
}