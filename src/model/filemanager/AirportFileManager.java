package model.filemanager;

import model.objects.Airport;
import java.util.Set;

public class AirportFileManager extends FileManager<Airport> {

    private static AirportFileManager airportFileManagerInst = null;
    public Set<Airport> airportSet;

    private AirportFileManager() {
        super("src/data/airports.json");
        airportSet = this.read(Airport.class);
    }

    public static AirportFileManager getInstance() {
        if (airportFileManagerInst == null)
            airportFileManagerInst = new AirportFileManager();

        return airportFileManagerInst;
    }

}
