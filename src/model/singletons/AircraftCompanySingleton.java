package model.singletons;

import model.objects.AircraftCompany;
import java.util.Set;

public class AircraftCompanySingleton extends Singleton<AircraftCompany> {

    private static AircraftCompanySingleton aircraftCompanySingleton = null;
    public Set<AircraftCompany> aircraftCompanySet;

    private AircraftCompanySingleton() {
        super("src/data/aircraftCompanies.json");
        aircraftCompanySet = this.read(AircraftCompany.class);
    }

    public static AircraftCompanySingleton getInstance() {
        if (aircraftCompanySingleton == null)
            aircraftCompanySingleton = new AircraftCompanySingleton();

        return aircraftCompanySingleton;
    }

    public AircraftCompany getAircraftCompanyById(int id) {
        for (AircraftCompany aircraftCompany : this.aircraftCompanySet) {
            if (aircraftCompany.getId() == id) {
                return aircraftCompany;
            }
        }
        System.out.println("Could not find an aircraft company with this id");
        return null;
    }

}
