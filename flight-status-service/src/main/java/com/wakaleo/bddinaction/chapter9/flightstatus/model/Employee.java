package com.wakaleo.bddinaction.chapter9.flightstatus.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Employee {

    private String name;
    private String birthday;

    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");

    public Employee() {
    }

    public Employee(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public DateTime getBirthday() {
        return DateTime.parse(birthday,format);
    }
}
