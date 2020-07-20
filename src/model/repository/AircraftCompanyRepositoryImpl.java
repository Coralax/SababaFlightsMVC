package model.repository;

import model.objects.AircraftCompany;
import model.filemanager.AircraftCompanyFileManager;

import java.util.HashSet;
import java.util.Set;

public class AircraftCompanyRepositoryImpl implements AircraftCompanyRepository {

    private Set<AircraftCompany> aircraftCompanySet;

    public AircraftCompanyRepositoryImpl() {
        this.aircraftCompanySet = AircraftCompanyFileManager.getInstance().aircraftCompanySet;
    }

    @Override
    public boolean addAircraft(AircraftCompany aircraftCompany, int aircraftID) {
        for (int id : aircraftCompany.getAircrafts()) {
            if (id == aircraftID) {
                return false;
            }
        }
        Set<Integer> newSet = aircraftCompany.getAircrafts();
        if (newSet.add(aircraftID)) {
            System.out.println("Aircraft added successfully!");
            aircraftCompany.setAircrafts(newSet);
            AircraftCompanyFileManager.getInstance().saveSet(this.aircraftCompanySet);
            return true;
        } else {
            System.out.println("\n"+"There was an error adding the particular aircraft"+"\n");
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

    @Override
    public AircraftCompany getAircraftCompanyById(long id) {
        for (AircraftCompany aircraftCompany : this.aircraftCompanySet) {
            if (aircraftCompany.getId() == id) {
                return aircraftCompany;
            }
        }
        System.out.println("\n"+ "Could not find an aircraft company with the provided ID! "+"\n");
        return null;
    }
}
