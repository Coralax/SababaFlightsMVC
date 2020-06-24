package model.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AircraftCompany {
    private String companyName;
    private String companyClass;                // Regular flight, low-cost, etc.

    public AircraftCompany() {}

    public AircraftCompany(String companyName) {
        this.companyName = companyName;
        this.companyClass = "regular";
    }

    public AircraftCompany(String companyName, String companyClass) {
        this.companyName = companyName;
        this.companyClass = companyClass;
    }

    @Override
    public String toString() {
        return "AircraftCompany{" +
                "companyName='" + companyName + '\'' +
                ", companyClass='" + companyClass + '\'' +
                '}';
    }

    public String getCompanyName() { return this.companyName; }
    public String getCompanyClass() { return this.companyClass; }

}
