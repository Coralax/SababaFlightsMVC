package com.example.main;
import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private static int aircraftsCount;
    private int aircraftID;
    private static List<Aircraft> aircraftsList;
    private AircraftCompany aircraftCompany;
    private int seatsCount;
    private String model;
    private List<Flight> flights;

    static {
        aircraftsCount = 0;
        aircraftsList = new ArrayList<>();
    }

    public Aircraft(AircraftCompany aircraftCompany, int seatsCount, String model) {
        this.aircraftID = aircraftsCount++;
        this.addAircraftToList(this);
        this.aircraftCompany = aircraftCompany;
        this.seatsCount = seatsCount;
        this.model = model;
    }

    public int getAircraftID() { return this.aircraftID; }
    public AircraftCompany getAircraftCompany() { return this.aircraftCompany; }
    public int getSeatsCount() { return this.seatsCount; }
    public String getModel() { return this.model; }
    public List<Flight> getFlights() { return this.flights; }
    public int getAircraftsCount() { return aircraftsList.size(); }

    public static Aircraft getAircarftByID(int id) {
        for (Aircraft aircraft : aircraftsList) {
            if (aircraft.aircraftID == id) {
                return aircraft;
            }
        }
        return null;
    }

    public static List<Aircraft> getAircraftsByCompanyName(String companyName) {
        List<Aircraft> aircraftsByCompanyName = new ArrayList<>();
        for (Aircraft aircraft : aircraftsList) {
            if (aircraft.aircraftCompany.getCompanyName().equals(companyName)) {
                aircraftsByCompanyName.add(aircraft);
            }
        }
        return aircraftsByCompanyName;
    }

    public void setAircraftCompany(AircraftCompany aircraftCompany) { this.aircraftCompany = aircraftCompany; }
    public void setSeatsCount(int seatsCount) { this.seatsCount = seatsCount; }
    public void setModel(String model) { this.model = model; }

    public boolean addFlight(Flight flight) {
        if (!this.flights.contains(flight)) {
            this.flights.add(flight);
            return true;
        }
        return false;
    }

    public boolean removeFlight(Flight flight) {
        if (flights.contains(flight)) {
            flights.remove(flight);
            return true;
        }
        return false;
    }

    public boolean addAircraftToList(Aircraft aircraft) {
        if (!aircraftsList.contains(aircraft)) {
            aircraftsList.add(aircraft);
            return true;
        }
        return false;
    }
}
