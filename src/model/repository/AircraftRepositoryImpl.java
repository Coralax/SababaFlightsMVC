package model.repository;

import model.objects.Aircraft;
import model.filemanager.AircraftFileManager;

import java.util.Set;

public class AircraftRepositoryImpl implements AircraftRepository{

    private Set<Aircraft> aircraftSet;

    public AircraftRepositoryImpl() {
        this.aircraftSet = AircraftFileManager.getInstance().aircraftSet;
    }

    @Override
    public Aircraft getAircraftById(long id) {
        for (Aircraft aircraft : this.aircraftSet) {
            if (aircraft.getId() == id) {
                return aircraft;
            }
        }
        System.out.println("\n"+"Could not find an aircraft with the provided ID! "+"\n");
        return null;
    }

}
