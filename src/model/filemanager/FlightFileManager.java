package model.filemanager;

import model.objects.Flight;
import java.util.Set;

public class FlightFileManager extends FileManager<Flight> {

    private static FlightFileManager flightFileManagerInst = null;
    public Set<Flight> flightSet;
    private int currency;   // 0 - USD; 1 - ILS

    private FlightFileManager() {
        super("src/data/flights.json");
        flightSet = this.read(Flight.class);
        this.currency = 0;
    }

    public static FlightFileManager getInstance() {
        if (flightFileManagerInst == null)
            flightFileManagerInst = new FlightFileManager();

        return flightFileManagerInst;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCurrency() {
        return currency;
    }
}
