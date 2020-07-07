package model.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AircraftCompany {

    static int aircraftCompaniesCount;
    private int id;
    private String companyName;
    private String companyClass;                // Regular flight, low-cost, etc.

    static { aircraftCompaniesCount = 0; }

    public AircraftCompany() { aircraftCompaniesCount++; }

    public AircraftCompany(String companyName) {
        this.id = aircraftCompaniesCount++;
        this.companyName = companyName;
        this.companyClass = "regular";
    }

    public AircraftCompany(String companyName, String companyClass) {
        this.id = aircraftCompaniesCount++;
        this.companyName = companyName;
        this.companyClass = companyClass;
    }

    public int getId() { return this.id ;}
    public String getCompanyName() { return this.companyName; }
    public String getCompanyClass() { return this.companyClass; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "AircraftCompany{" +
                "companyName='" + companyName + '\'' +
                ", companyClass='" + companyClass + '\'' +
                '}';
    }

}
