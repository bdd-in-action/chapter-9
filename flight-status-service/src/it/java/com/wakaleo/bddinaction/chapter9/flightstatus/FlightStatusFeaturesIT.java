package com.wakaleo.bddinaction.chapter9.flightstatus;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber-html-report", "json:target/report.json" })
public class FlightStatusFeaturesIT {
}
