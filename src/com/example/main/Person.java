package com.example.main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private String firstName, lastName, email, birthDateString;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String firstName, String lastName, String email, String birthDateString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDateString = birthDateString;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public String getBirthDateString() { return this.birthDateString; }
    // TODO: getBirthDate() which returns a Date object

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthDateString(String birthDateString) { this.birthDateString = birthDateString; }

    // TODO: create print() function
}
