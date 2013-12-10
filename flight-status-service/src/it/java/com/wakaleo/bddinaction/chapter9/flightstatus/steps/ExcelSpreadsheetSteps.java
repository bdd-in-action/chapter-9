package com.wakaleo.bddinaction.chapter9.flightstatus.steps;

import com.google.common.io.Files;
import com.wakaleo.bddinaction.chapter9.flightstatus.model.Employee;
import com.wakaleo.bddinaction.chapter9.flightstatus.services.EmployeeService;
import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.util.Date;
import java.util.List;

public class ExcelSpreadsheetSteps {

    EmployeeService employeeService = new EmployeeService();
    Date today;
    File birthdaySpreadsheet;

    @Given("^the following employees:$")
    public void the_following_staff_members(DataTable employees) throws Throwable {
        List<Employee> existingEmployees = employees.asList(Employee.class);
        employeeService.addEmployees(existingEmployees);
    }

    @Given("^today is (.*)$")
    public void today_is(@Format("dd-MM-yyyy") Date today) throws Throwable {
        this.today = today;
    }

    @When("^I export this week's birthday list$")
    public void I_export_this_weeks_birthday_list() throws Throwable {
        File outputDirectory = Files.createTempDir();
        birthdaySpreadsheet = employeeService.exportBirthdaysForWeekStarting(today).inDirectory(outputDirectory);
    }

    @Then("^I should obtain a spreadsheet containing the following:$")
    public void I_should_obtain_a_spreadsheet_containing_the_following(DataTable expectedEmployees) throws Throwable {
    }

}
