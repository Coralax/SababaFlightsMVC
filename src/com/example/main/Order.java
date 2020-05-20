package com.example.main;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String flightCompany;
    private boolean roundTrip;
    private int orderId;
    private List<String> flightTo = new ArrayList<>();
    private List<String> flightFrom = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private long creditCard;
    private double totalCost;


    public Order(String flightCompany, boolean roundTrip, int orderId, Passenger ownerPassenger,long creditCard, double totalCost)
    {
        this.flightCompany = flightCompany;
        this.roundTrip = roundTrip;
        this.orderId = orderId;
        this.creditCard = creditCard;
        this.totalCost = totalCost;
    }

    public boolean isRoundTrip() { return roundTrip; }
    public double getTotalCost() { return totalCost; }
    public int getOrderId() { return orderId; }
    public long getCreditCard() { return creditCard; }
    public String getFlightCompany() { return flightCompany; }
    public List<Passenger> getPassengers() { return passengers; }
    public Passenger getMainPassenger(){ return this.passengers.get(0); }

    public void setRoundTrip(boolean roundTrip) { this.roundTrip = roundTrip; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCreditCard(long creditCard) { this.creditCard = creditCard; }
    public void setFlightCompany(String flightCompany) { this.flightCompany = flightCompany; }
    public void setFlightTo(List<String> flightTo) { this.flightTo = flightTo; }
    public void setFlightFrom(List<String> flightFrom) { this.flightFrom = flightFrom; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }



}

