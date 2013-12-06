package com.wakaleo.bddinaction.chapter9.flightstatus.resources;

import com.wakaleo.bddinaction.chapter9.flightstatus.model.Flight;
import com.wakaleo.bddinaction.chapter9.flightstatus.service.FlightService;
import com.wakaleo.bddinaction.chapter9.flightstatus.service.SimpleFlightService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("flights")
public class FlightResource {

    // TODO: Add dependency injection here
    FlightService flightService = new SimpleFlightService();

    public FlightResource() {}

    @Path("/status")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatus()
    {
        return "{'status':'OK'}";
    }

    @GET
    @Path("/{flightNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findByFlightNumber(@PathParam("flightNumber") String flightNumber) {
        return flightService.findByFlightNumber(flightNumber);
    }

}