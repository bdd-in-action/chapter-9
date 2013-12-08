package com.wakaleo.bddinaction.chapter9.flightstatus.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.ImmutableList;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Flight {

    private String flightNumber;
    private String departure;
    private String destination;
    private String time;

    public Flight() {
    }

    public Flight(String flightNumber, String departure, String destination, String time) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.time = time;
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

    public String getTime() { return time; }

    public static FlightBuilder number(String flightNumber) {
        return new FlightBuilder(flightNumber);
    }

    public static class FlightBuilder {
        String departure;
        String destination;
        String flightNumber;
        List<DayOfTheWeek> departureDays;

        public FlightBuilder(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public FlightBuilder from(String departure) {
            this.departure = departure;
            return this;
        }

        public FlightBuilder to(String destination) {
            this.destination = destination;
            return this;
        }
        public Flight at(String departureTime) {
            return new Flight(flightNumber, departure, destination, departureTime);
        }
    }

}