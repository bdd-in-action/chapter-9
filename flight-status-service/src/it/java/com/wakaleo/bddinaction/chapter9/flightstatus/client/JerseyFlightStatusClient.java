package com.wakaleo.bddinaction.chapter9.flightstatus.client;


import com.wakaleo.bddinaction.chapter9.flightstatus.model.Flight;
import com.wakaleo.bddinaction.chapter9.flightstatus.model.FlightType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JerseyFlightStatusClient implements FlightStatusClient {

    private final String BASE_URL = "http://localhost:8080/rest/flights";

    @Override
    public Flight findByFlightNumber(String flightNumber) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL).path(flightNumber);
        return webTarget.request().buildGet().invoke(Flight.class);
    }

    @Override
    public String findByFlightNumberInJson(String flightNumber) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL).path(flightNumber);
        return webTarget.request().buildGet().invoke(String.class);
    }

    private GenericArrayType listOfFlights() {
        return new GenericArrayType() {
            @Override
            public Type getGenericComponentType() {
                return Flight.class;
            }
        };
    }
    @Override
    public List<Flight> findByDepartureCityAndType(String departure, FlightType type) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL)
                                    .path("from/" + departure)
                                    .queryParam("flightType", type);
        Flight[] flights = ((Flight[]) webTarget.request().buildGet().invoke(new GenericType(listOfFlights())));

        return new ArrayList(Arrays.asList(flights));
    }

    @Override
    public String findByDepartureCityAndTypeInJson(String departure, FlightType type) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL)
                .path("from/" + departure)
                .queryParam("flightType", type);
        return webTarget.request().buildGet().invoke(String.class);
    }

}
