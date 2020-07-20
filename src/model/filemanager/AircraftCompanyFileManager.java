package model.filemanager;

import model.objects.AircraftCompany;
import java.util.Set;

public class AircraftCompanyFileManager extends FileManager<AircraftCompany> {

    private static AircraftCompanyFileManager aircraftCompanyFileManagerInst = null;
    public Set<AircraftCompany> aircraftCompanySet;

    private AircraftCompanyFileManager() {
        super("src/data/aircraftCompanies.json");
        aircraftCompanySet = this.read(AircraftCompany.class);
    }

    public static AircraftCompanyFileManager getInstance() {
        if (aircraftCompanyFileManagerInst == null)
            aircraftCompanyFileManagerInst = new AircraftCompanyFileManager();

        return aircraftCompanyFileManagerInst;
    }

}
