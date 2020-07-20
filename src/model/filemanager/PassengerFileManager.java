package model.filemanager;

import model.objects.Passenger;
import java.util.Set;

public class PassengerFileManager extends FileManager<Passenger> {

    private static PassengerFileManager passengerFileManagerInst = null;
    public Set<Passenger> passengerSet;

    private PassengerFileManager() {
        super("src/data/passengers.json");
        passengerSet = this.read(Passenger.class);
    }

    public static PassengerFileManager getInstance() {
        if (passengerFileManagerInst == null)
            passengerFileManagerInst = new PassengerFileManager();

        return passengerFileManagerInst;
    }

}
