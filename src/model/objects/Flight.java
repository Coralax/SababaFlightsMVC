package model.objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Flight {
    private static int staticFlightID;
    private int flightID;
    private String destination;
    private Aircraft aircraft;
    private Airport departureAirport, destinationAirport;
    private String departureDate, arrivalDate;
    private double flightPrice;
    private boolean direct;

    static { staticFlightID = 0; }

    public Flight() {}

    public Flight(Aircraft aircraft, Airport departureAirport, Airport destinationAirport,
                  String departureDate, String arrivalDate, double flightPrice, boolean direct,String destination) {
        this.flightID = staticFlightID++;
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.direct = direct;
        this.destination=destination;
    }

    public Aircraft getAircraftID() { return this.aircraft; }
    public int getFlightID() { return flightID; }
    public Airport getDepartureAirport() { return this.departureAirport; }
    public Airport getDestinationAirport() { return this.destinationAirport; }
    public String getDepartureDate() { return this.departureDate; }
    public String getArrivalDate() { return this.arrivalDate; }
    public double getFlightPrice() { return this.flightPrice; }
    public boolean isDirect() { return this.direct; }
    public String getDestination() { return destination; }



    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public void setDepartureAirport(Airport departureAirport) { this.departureAirport = departureAirport; }
    public void setDestinationAirport(Airport destinationAirport) { this.destinationAirport = destinationAirport; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }
    public void setFlightPrice(double flightPrice) { this.flightPrice = flightPrice; }
    public void setDirect(boolean direct) { this.direct = direct; }
    public void setFlightID(int flightID) { this.flightID = flightID; }
    public void setDestination(String destination) { this.destination = destination; }


//    // function to generate a random string of length n
//    static String randomizeFlightNumber(int n)
//    {
//        // chose a Character random from this String
//        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//                + "0123456789";
//        // create StringBuffer size of AlphaNumericString
//        StringBuilder sb = new StringBuilder(n);
//        for (int i = 0; i < n; i++) {
//            // generate a random number between
//            // 0 to AlphaNumericString variable length
//            int index
//                    = (int)(AlphaNumericString.length()
//                    * Math.random());
//            // add Character one by one in end of sb
//            sb.append(AlphaNumericString
//                    .charAt(index));
//        }
//        return sb.toString();
//    }
    //make global
    public LocalDate convertToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter.parse(date);
       return (LocalDate.parse(departureDate, formatter));
    }

    @Override
    public String toString() {
        return
                " Flight ID: " + flightID + "\n"+
                " Aircraft: " + aircraft + "\n" +
                " Destination: "+ destination +"\n"+
                " Departure airport: " + departureAirport + "\n" +
                " Destination airport: " + destinationAirport + "\n" +
                " Departure date: " + departureDate + "\n" +
                " Arrival date: " + arrivalDate + "\n" +
                " Flight price: " + flightPrice + "\n" +
                " Is direct: " + direct + "\n" ;
    }
}
