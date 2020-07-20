package model.repository;

import model.objects.Passenger;
import model.filemanager.PassengerFileManager;

import java.util.Set;

public class PassengerRepositoryImpl implements PassengerRepository {

    private Set<Passenger> passengerSet;
    private PassengerFileManager passengerFileManagerInst;

    public PassengerRepositoryImpl() { }

    public Passenger getPassengerByID(long passengerID) {
        passengerSet= PassengerFileManager.getInstance().passengerSet;
        for (Passenger passenger : this.passengerSet) {
            if (passenger.getId() == passengerID) {
                return passenger;
            }
        }
        return null;
    }
}
