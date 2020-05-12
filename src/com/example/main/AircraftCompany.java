package com.example.main;

import java.util.List;

public class AircraftCompany {
    private List<Aircraft> aircrafts;
    private String companyClass;                // Regular flight, low-cost, etc.

    public List<Aircraft> getAircrafts() { return aircrafts; }
    public int getAircraftCount() { return this.aircrafts.size(); }
    public String getCompanyClass() { return this.companyClass; }

    public void setCompanyClass(String companyClass) { this.companyClass = companyClass; }

    public boolean addAircraft(Aircraft aircraft) {
        if (!this.aircrafts.contains(aircraft)) {
            this.aircrafts.add(aircraft);
            return true;
        }
        return false;
    }

    public boolean removeAircraft(Aircraft aircraft) {
        if (this.aircrafts.contains(aircraft)) {
            this.aircrafts.remove(aircraft);
            return true;
        }
        return false;
    }
}
