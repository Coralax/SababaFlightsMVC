package model.repository;

import model.objects.Aircraft;
import model.objects.AircraftCompany;
import model.FileManager;

import java.util.HashSet;
import java.util.Set;

public class AircraftCompanyRepositoryImpl implements AircraftCompanyRepository {

    @Override
    public boolean addAircraft(AircraftCompany aircraftCompany, int aircraftID) {
        for (int id : aircraftCompany.getAircrafts()) {
            if (id == aircraftID) {
                return false;
            }
        }
        Set<Integer> newSet = aircraftCompany.getAircrafts();
        if (newSet.add(aircraftID)) {
            System.out.println("Aircraft addded");
            aircraftCompany.setAircrafts(newSet);
            return true;
        } else {
            System.out.println("There was an error adding the aircraft");
            return false;
        }
    }

    @Override
    public boolean removeAircraft(AircraftCompany aircraftCompany, int aircraftID) {
        boolean isRemoved = false;
        Set<Integer> newSet = new HashSet<>();
        for (int id : aircraftCompany.getAircrafts()) {
            if (id == aircraftID) {
                isRemoved = true;
                continue;
            }
            newSet.add(id);
        }
        if (isRemoved) {
            aircraftCompany.setAircrafts(newSet);
            return true;
        }
        return false;
    }
}
