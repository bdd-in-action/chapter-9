package com.wakaleo.bddinaction.chapter9.flightstatus.services;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.wakaleo.bddinaction.chapter9.flightstatus.model.Employee;

import java.io.File;
import java.util.Date;
import java.util.List;

public class EmployeeService {

    List<Employee> employees = Lists.newArrayList();

    public void addEmployees(List<Employee> existingEmployees) {
        employees.addAll(existingEmployees);
    }

    public BirthdayExportBuilder exportBirthdaysForWeekStarting(Date today) {
        return new BirthdayExportBuilder(today);
    }

    public class BirthdayExportBuilder {
        Date forDate;
        public BirthdayExportBuilder(Date forDate) {
            this.forDate = forDate;
        }

        public File inDirectory(File outputDirectory) {
            return null;
        }
    }
}
