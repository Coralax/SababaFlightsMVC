package com.example.main;

import java.util.ArrayList;
import java.util.List;

public class AircraftCompany {
    private static List<String> companiesNames;
    private String companyName, companyClass;                // Regular flight, low-cost, etc.

    static { companiesNames = new ArrayList<>(); }

    public AircraftCompany(String companyName) {
        this.companyName = companyName;
        this.companyClass = "regular";
        this.addCompanyName(this.companyName);
    }

    public AircraftCompany(String companyName, String companyClass) {
        this.companyName = companyName;
        this.companyClass = companyClass;
    }

    public String getCompanyName() { return this.companyName; }
    public String getCompanyClass() { return this.companyClass; }

    private boolean addCompanyName(String companyName) {
        if (!companiesNames.contains(companyName)) {
            companiesNames.add(companyName);
            return true;
        }
        return false;
    }
}
