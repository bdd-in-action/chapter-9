package com.wakaleo.bddinaction.chapter9.flightstatus.client;

import com.wakaleo.bddinaction.chapter9.flightstatus.model.Flight;
import com.wakaleo.bddinaction.chapter9.flightstatus.model.FlightType;

import java.util.List;

/**
 * A description goes here.
 * User: john
 * Date: 11/12/2013
 * Time: 6:40 AM
 */
public interface FlightStatusClient {
    Flight findByFlightNumber(String flightNumber);

    String findByFlightNumberInJson(String flightNumber);

    List<Flight> findByDepartureCityAndType(String departure, FlightType type);

    String findByDepartureCityAndTypeInJson(String departure, FlightType type);
}
