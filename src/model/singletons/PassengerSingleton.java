package model.singletons;

import model.objects.Passenger;
import java.util.Set;

public class PassengerSingleton extends Singleton<Passenger> {

    private static PassengerSingleton passengerSingletonInstance = null;
    public Set<Passenger> passengerSet;

    private PassengerSingleton() {
        super("src/data/passengers.json");
        passengerSet = this.read(Passenger.class);
    }

    public static PassengerSingleton getInstance() {
        if (passengerSingletonInstance == null)
            passengerSingletonInstance = new PassengerSingleton();

        return passengerSingletonInstance;
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
