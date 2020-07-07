package model.objects;

import model.adapter.FlightCurrencyAdapterImpl;
import model.singletons.FlightSingleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight {

    private static int staticFlightID;
    private int id;
    private String destination;
    private Aircraft aircraft;
    private Airport departureAirport, destinationAirport;
    private String departureDate, arrivalDate;
    private double flightPrice;
    private boolean direct;
    private int seatsLeft;

    static { staticFlightID = 0; }

    public Flight() { staticFlightID++; }

    public Flight(Aircraft aircraft, Airport departureAirport, Airport destinationAirport,
                  String departureDate, String arrivalDate, double flightPrice, boolean direct,String destination, int seatsLeft) {
        this.id = staticFlightID++;
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightPrice = flightPrice;
        this.direct = direct;
        this.destination=destination;
        this.seatsLeft=seatsLeft;
    }

    public Aircraft getAircraft() { return this.aircraft; }
    public int getId() { return id; }
    public Airport getDepartureAirport() { return this.departureAirport; }
    public Airport getDestinationAirport() { return this.destinationAirport; }
    public String getDepartureDate() { return this.departureDate; }
    public String getArrivalDate() { return this.arrivalDate; }
    public double getFlightPrice() { return this.flightPrice; }
    public boolean isDirect() { return this.direct; }
    public String getDestination() { return destination; }
    public int getSeatsLeft() { return seatsLeft; }

    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public void setDepartureAirport(Airport departureAirport) { this.departureAirport = departureAirport; }
    public void setDestinationAirport(Airport destinationAirport) { this.destinationAirport = destinationAirport; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }
    public void setFlightPrice(double flightPrice) { this.flightPrice = flightPrice; }
    public void setDirect(boolean direct) { this.direct = direct; }
    public void setId(int id) { this.id = id; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setSeatsLeft(int seatsLeft) { this.seatsLeft = seatsLeft; }


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightID == flight.flightID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightID);
    }

    @Override
    public String toString() {
        int currency = FlightSingleton.getInstance().getCurrency();
        if (currency == 1) {
            FlightCurrencyAdapterImpl currencyAdapter = new FlightCurrencyAdapterImpl(this);
            return
                    " Flight ID: " + id + "\n"+
                    " Aircraft: " + aircraft + "\n" +
                    " Destination: "+ destination +"\n"+
                    " Departure airport: " + departureAirport + "\n" +
                    " Destination airport: " + destinationAirport + "\n" +
                    " Departure date: " + departureDate + "\n" +
                    " Arrival date: " + arrivalDate + "\n" +
                    " Flight price: " + currencyAdapter.getFlightPrice() + "\n" +
                    " Is direct: " + direct + "\n" ;
        } else {
            return
                    " Flight ID: " + id + "\n"+
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
}
