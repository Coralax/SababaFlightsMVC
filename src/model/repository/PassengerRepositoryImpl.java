package model.repository;

import model.objects.Agent;
import model.objects.Passenger;
import model.FileManager;
import model.singletons.AgentSingleton;
import model.singletons.PassengerSingleton;

import java.util.Set;

public class PassengerRepositoryImpl implements PassengerRepository {

    private Set<Passenger> passengerSet;
    private PassengerSingleton passengerSingleton;

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

    public Passenger passengerExist(long id) {
        //JSON parser object to parse read file
        passengerSingleton = PassengerSingleton.getInstance();
        passengerSet = passengerSingleton.passengerSet;

        for (Passenger passenger : passengerSet) {
            if (passenger.getId() == id) {
                System.out.println("User already exists");
                return passenger;
            }
        }
        return null;
    }

}
