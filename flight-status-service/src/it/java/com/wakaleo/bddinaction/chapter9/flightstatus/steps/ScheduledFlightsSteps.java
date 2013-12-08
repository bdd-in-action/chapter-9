package com.wakaleo.bddinaction.chapter9.flightstatus.steps;

import com.wakaleo.bddinaction.chapter9.flightstatus.client.FlightStatusClient;
import com.wakaleo.bddinaction.chapter9.flightstatus.model.FlightType;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class ScheduledFlightsSteps {

    String departure;
    List retrievedFlights;

    @Given("^I want to know the flights out of (.*)$")
    public void I_want_to_check_the_flights_out_o_(String departure) throws Throwable {
        this.departure = departure;
    }

    @When("^I request the (.*) flights$")
    public void I_request_flights_of_type(FlightType flightType) throws Throwable {
        FlightStatusClient client = new FlightStatusClient();
        retrievedFlights = client.findByDepartureCityAndType(departure, flightType);
    }

    @Then("^I should see the following flights:$")
    public void I_should_see_the_following_flights(DataTable expectedFlights) throws Throwable {
        expectedFlights.diff(retrievedFlights);
    }


}
