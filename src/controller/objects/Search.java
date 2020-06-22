package controller.objects;

import java.time.LocalDate;

public class Search {
    private LocalDate departure;
    private LocalDate arrival;
    private String destination;
    private int numberOfPassengers;
    private boolean standardFlight;

    public Search(LocalDate departure, LocalDate arrival, String destination, int numberOfPassengers, boolean standardFlight) {
        this.departure = departure;
        this.arrival = arrival;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.standardFlight = standardFlight;
    }


    public Search(LocalDate departure, LocalDate arrival, String destination, int numberOfPassengers) {
        this.departure = departure;
        this.arrival = arrival;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isStandardFlight() {
        return standardFlight;
    }

    public void setStandardFlight(boolean standardFlight) {
        this.standardFlight = standardFlight;
    }
}
