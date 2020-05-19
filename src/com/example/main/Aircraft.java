package com.example.main;
import java.util.List;

public class Aircraft {
    private static int staticAircraftID;
    private int aircraftID;
    private AircraftCompany aircraftCompany;
    private int seatsCount;
    private String model;
    private List<Flight> flights;

    static { staticAircraftID = 0; }

    public Aircraft(AircraftCompany aircraftCompany, int seatsCount, String model) {
        this.aircraftID = staticAircraftID++;
        this.aircraftCompany = aircraftCompany;
        this.seatsCount = seatsCount;
        this.model = model;
    }

    public int getAircraftID() { return this.aircraftID; }
    public AircraftCompany getAircraftCompany() { return this.aircraftCompany; }
    public int getSeatsCount() { return this.seatsCount; }
    public String getModel() { return this.model; }
    public List<Flight> getFlights() { return this.flights; }

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
}
