package model.objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight {
    private static int staticFlightID;
    private int flightID;
    private String flightNumber;
    private Aircraft aircraft;
    private Airport departureAirpot, destinationAirport;
    private String departureDate, arrivalDate;
    private double flightPrice;
    private boolean direct;


    static { staticFlightID = 0; }

    public Flight() {}

    public Flight(Aircraft aircraft, Airport departureAirpot, Airport destinationAirport,
                  String departureDate, String arrivalDate, double flightPrice, boolean direct) {
        this.flightID = staticFlightID++;
        this.flightNumber = randomizeFlightNumber(5);
        this.aircraft = aircraft;
        this.departureAirpot = departureAirpot;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.direct = direct;
    }

    public Flight(String flightNumber, Aircraft aircraft, Airport departureAirpot, Airport destinationAirport,
                  String departureDate, String arrivalDate, double flightPrice, boolean direct) {
        this.flightID = staticFlightID++;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.departureAirpot = departureAirpot;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.direct = direct;
    }


    public Aircraft getAircraftID() { return this.aircraft; }
    public int getFlightID() { return flightID; }
    public Airport getDepartureAirpot() { return this.departureAirpot; }
    public Airport getDestinationAirport() { return this.destinationAirport; }
    public String getDepartureDate() { return this.departureDate; }
    public String getArrivalDate() { return this.arrivalDate; }
    public double getFlightPrice() { return this.flightPrice; }
    public boolean isDirect() { return this.direct; }

    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public void setDepartureAirport(Airport departureAirpot) { this.departureAirpot = departureAirpot; }
    public void setDestinationAirport(Airport destinationAirport) { this.destinationAirport = destinationAirport; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }
    public void setFlightPrice(double flightPrice) { this.flightPrice = flightPrice; }
    public void setDirect(boolean direct) { this.direct = direct; }

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
    public LocalDate convertToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter.parse(date);
       return (LocalDate.parse(departureDate, formatter));
    }

    @Override
    public String toString() {
        return
                " Flight ID: " + flightID + "\n"+
                " Flight number: '" + flightNumber + "\n"+
                " Aircraft: " + aircraft + "\n" +
                " Departure airport: " + departureAirpot + "\n" +
                " Destination airport: " + destinationAirport + "\n" +
                " Departure date: " + departureDate + "\n" +
                " Arrival date: " + arrivalDate + "\n" +
                " Flight price: " + flightPrice + "\n" +
                " Is direct: " + direct + "\n" ;
    }
}
