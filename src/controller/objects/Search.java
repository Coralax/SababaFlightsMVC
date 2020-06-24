package controller.objects;

import java.time.LocalDate;

public class Search {
    private LocalDate departure;
    private LocalDate arrival;
    private String destination;
    private int numberOfPassengers;
    private boolean directFlight;
    private boolean cabinClass;


      public Search()
    {

    }
    public Search(LocalDate departure, LocalDate arrival, String destination, int numberOfPassengers,boolean cabinClass,boolean directFlight) {
        this.departure = departure;
        this.arrival = arrival;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.cabinClass=cabinClass;
        this.directFlight = directFlight;
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

    public boolean isDirectFlight() {
        return directFlight;
    }

    public void setDirectFlight(boolean directFlight) {
        this.directFlight = directFlight;
    }
    public void setCabinClass(boolean cabinClass) {
        this.cabinClass = cabinClass;
    }
    public boolean isCabinClass() {
        return cabinClass;
    }
}
