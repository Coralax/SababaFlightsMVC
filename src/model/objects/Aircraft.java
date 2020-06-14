package model.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private static int aircraftsCount;
    private int aircraftID;
    private AircraftCompany aircraftCompany;
    private int seatsCount;
    private String model;
    private List<Flight> flights;

    static {
        aircraftsCount = 0;
    }

    public Aircraft(AircraftCompany aircraftCompany, int seatsCount, String model) {
        this.aircraftID = aircraftsCount++;
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

    /* TODO: Implement getAircraftByID(List<Aircraft> aircraftList, int id) in Repository */
    /* TODO: Implement getAircraftByCompanyName(List<Aircraft> aircraftList, String companyName) in Repository */
    /* TODO: Implement addFlight(Flight flight, int id) in Repository */
    /* TODO: Implement removeFlight(Flight flight) in Repository */

    @Override
    public String toString() {
        return super.toString() + "\n"+
                " Aircraft ID=" + aircraftID + "\n"+
                " Aircraft company=" + aircraftCompany + "\n"+
                " Seats count=" + seatsCount + "\n"+
                " Model='" + model + "\n"+
                " Flights=" + flights ;
    }
}
