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


    public String getCompanyName() { return this.companyName; }
    public String getCompanyClass() { return this.companyClass; }


    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setCompanyClass(String companyClass) { this.companyClass = companyClass; }

    @Override
    public String toString() {
        return
                " Company name: " + companyName + "\n" +
                " Company class: " + companyClass;
    }
}
