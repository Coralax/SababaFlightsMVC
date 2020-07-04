package model.objects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Destination {

    public String destCountry;
    public List<String> destCitiesStates = new ArrayList<>();

    public Destination() {
    }

    public Destination(String destCountry, List<String> destCitiesStates) {
        this.destCountry = destCountry;
        this.destCitiesStates = destCitiesStates;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public List<String> getDestCitiesStates() {
        return destCitiesStates;
    }

    public void setDestCitiesStates(List<String> destCitiesStates) {
        this.destCitiesStates = destCitiesStates;
    }

    @Override
    public String toString() {
        return
                "Destination country: " + destCountry + '\n' +
                "Destination cities or states:" + destCitiesStates;
    }
}


