package com.example.main;

public class Main {
    public static void main(String[] args) {

        AircraftCompany ac1 = new AircraftCompany("Test Company");
        AircraftCompany ac2 = new AircraftCompany("Another Company");
        Aircraft a = new Aircraft(ac1, 100, "Boeing 767");
        Aircraft b = new Aircraft(ac2, 90, "Boing 767");
        for (Aircraft aircraft : Aircraft.getAircraftsByCompanyName("Test Company")) {
            System.out.println(aircraft.getModel());
        }

        Airport airport1 = new Airport("Some Address", "DBG", "T1");
        airport1.addTerminal("T3");
        Airport airport2 = new Airport("Another Address", "NYC", "G2");
        System.out.println(airport1.getName() + " terminals:");
        for (String terminal : airport1.getTerminals()) {
            System.out.println(terminal);
        }
        System.out.println(airport2.getName() + " terminals:");
        for (String terminal : airport2.getTerminals()) {
            System.out.println(terminal);
        }
    }
}