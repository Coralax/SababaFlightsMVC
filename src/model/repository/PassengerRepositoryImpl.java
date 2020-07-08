package model.repository;

import model.objects.Passenger;
import model.FileManager;
import model.singletons.PassengerSingleton;

import java.util.Set;

public class PassengerRepositoryImpl implements PassengerRepository {

    private Set<Passenger> passengerSet;

    public PassengerRepositoryImpl() {
        this.passengerSet = PassengerSingleton.getInstance().passengerSet;
    }

    public Passenger getPassengerByID(long passengerID) {
        for (Passenger passenger : this.passengerSet) {
            if (passenger.getId() == passengerID) {
                return passenger;
            }
        }
        System.out.println("Could not find a passenger with this id");
        return null;
    }

}
