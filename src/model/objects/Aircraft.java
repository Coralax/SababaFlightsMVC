package model.objects;

public class Aircraft {
    private static int aircraftsCount;
    private int id;
    private int aircraftCompanyID;
    private int seatsCount;
    private String model;

    public Aircraft() {
        aircraftsCount++;
    }

    public Aircraft(int aircraftCompanyID, int seatsCount, String model) {
        this.id = aircraftsCount++;
        this.aircraftCompanyID = aircraftCompanyID;
        this.seatsCount = seatsCount;
        this.model = model;
    }

    //Getters
    public int getId() { return this.id; }
    public int getAircraftCompanyID() { return this.aircraftCompanyID; }
    public int getSeatsCount() { return this.seatsCount; }
    public String getModel() { return this.model; }

    //Setters
    public void setAircraftCompanyID(int aircraftCompanyID) { this.aircraftCompanyID = aircraftCompanyID; }
    public void setSeatsCount(int seatsCount) { this.seatsCount = seatsCount; }
    public void setModel(String model) { this.model = model; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return
                " Aircraft ID: " + id + " ," +
                " Aircraft Company: " + aircraftCompanyID + " ," +
                " Seats Count: " + seatsCount + " ," +
                " Model: " + model;
    }

}
