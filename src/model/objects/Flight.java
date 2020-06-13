package model.objects;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
    private static int staticFlightID;
    private int flightID;
    private String flightNumber;
    private Aircraft aircraft;
    private Airport departureAirpot, destinationAirport;
    private Date departureDate, arrivalDate;
    private double flightPrice;
    private boolean isAvailable;

    static { staticFlightID = 0; }

    public Flight(Aircraft aircraft, Airport departureAirpot, Airport destinationAirport,
                  Date departureDate, Date arrivalDate, double flightPrice, boolean isAvailable) {
        this.flightID = staticFlightID++;
        this.flightNumber = randomizeFlightNumber(5);
        this.aircraft = aircraft;
        this.departureAirpot = departureAirpot;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.isAvailable = isAvailable;
    }

    public Flight(String flightNumber, Aircraft aircraft, Airport departureAirpot, Airport destinationAirport,
                  Date departureDate, Date arrivalDate, double flightPrice, boolean isAvailable) {
        this.flightID = staticFlightID++;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.departureAirpot = departureAirpot;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.isAvailable = isAvailable;
    }

    public Aircraft getAircraftID() { return this.aircraft; }
    public int getFlightID() { return flightID; }
    public Airport getDepartureAirpot() { return this.departureAirpot; }
    public Airport getDestinationAirport() { return this.destinationAirport; }
    public Date getDepartureDate() { return this.departureDate; }
    public Date getArrivalDate() { return this.arrivalDate; }
    public double getFlightPrice() { return this.flightPrice; }
    public boolean getIsAvailabe() { return this.isAvailable; }

    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public void setDepartureAirpot(Airport departureAirpot) { this.departureAirpot = departureAirpot; }
    public void setDestinationAirport(Airport destinationAirport) { this.destinationAirport = destinationAirport; }
    public void setDepartureDate(Date departureDate) { this.departureDate = departureDate; }
    public void setArrivalDate(Date arrivalDate) { this.arrivalDate = arrivalDate; }
    public void setFlightPrice(double flightPrice) { this.flightPrice = flightPrice; }
    public void setAvailable(boolean available) { isAvailable = available; }

    // function to generate a random string of length n
    static String randomizeFlightNumber(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
