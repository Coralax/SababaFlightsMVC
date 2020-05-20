package com.example.main;

// :TODO// how to IMPLEMENT the functions of the list


import java.util.ArrayList;
import java.util.List;

public class Order {
    private String flightCompany;
    private boolean roundTrip;
    private int orderId;
    private List<Flight> flightTo = new ArrayList<>();
    private List<Flight> flightFrom = new ArrayList<>();
    private Passenger ownerPassenger;
    private List<Passenger> otherPassenger = new ArrayList<>();
    private long creditCard;
    private double totalCost;


    public Order(String flightCompany, boolean roundTrip, int orderId, Passenger ownerPassenger,long creditCard, double totalCost)
    {
        this.flightCompany = flightCompany;
        this.roundTrip = roundTrip;
        this.orderId = orderId;
        this.ownerPassenger = ownerPassenger;
        this.creditCard = creditCard;
        this.totalCost = totalCost;

//        this.addFlightTo(this.flightTo);
//        this.addFlightFrom(this.flightFrom);
//        this.addOtherPassenger(this.otherPassenger);
    }

    public boolean isRoundTrip() { return roundTrip; }
    public double getTotalCost() { return totalCost; }
    public int getOrderId() { return orderId; }
    public long getCreditCard() { return creditCard; }
    public String getFlightCompany() { return flightCompany; }
    public Passenger getOwnerPassenger() { return ownerPassenger; }

    public void setRoundTrip(boolean roundTrip) { this.roundTrip = roundTrip; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCreditCard(long creditCard) { this.creditCard = creditCard; }
    public void setFlightCompany(String flightCompany) { this.flightCompany = flightCompany; }
    public void setOwnerPassenger(Passenger ownerPassenger) { this.ownerPassenger = ownerPassenger; }


//    private boolean addFlightTo(String _flightTo)
//    {
//        if (!flightTo.contains(_flightTo)) {
//            flightTo.add(_flightTo);
//            return true;
//        }
//        return false;
//    }
//    private boolean addFlightFrom(String _flightFrom)
//    {
//        if (!flightFrom.contains(_flightFrom)) {
//            flightFrom.add(_flightFrom);
//            return true;
//        }
//        return false;
//    }
//    private boolean addOtherPassenger(String _otherPassenger)
//    {
//        if (!otherPassenger.contains(_otherPassenger)) {
//            otherPassenger.add(_otherPassenger);
//            return true;
//        }
//        return false;
//    }
}

