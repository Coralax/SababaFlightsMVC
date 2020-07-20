package model.filemanager;

import model.objects.Aircraft;
import java.util.Set;

public class AircraftFileManager extends FileManager<Aircraft> {

    private static AircraftFileManager aircraftFileManagerInst = null;
    public Set<Aircraft> aircraftSet;

    private AircraftFileManager() {
        super("src/data/aircrafts.json");
        aircraftSet = this.read(Aircraft.class);
    }

    public static AircraftFileManager getInstance() {
        if (aircraftFileManagerInst == null)
            aircraftFileManagerInst = new AircraftFileManager();

        return aircraftFileManagerInst;
    }

}
