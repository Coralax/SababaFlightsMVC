package model.repository;

import model.objects.AircraftCompany;
import model.FileManager;

public class AircraftCompanyRepositoryImpl implements AircraftCompanyRepository {

    private FileManager<AircraftCompany> fileManager;

    public AircraftCompanyRepositoryImpl(FileManager<AircraftCompany> fileManager) {

    }
}
