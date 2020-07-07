package model.objects;

import model.adapter.OrderCurrencyAdapterImpl;
import model.repository.OrderRepositoryImpl;
import model.singletons.FlightSingleton;

import java.util.List;

public class Order {

    static int ordersCount;
    int agentCode;
    AircraftCompany flightCompany;
    boolean roundTrip;
    long id;
    double totalCost;
    long creditCard;
    List<Flight> flightTo;
    List<Flight> flightFrom;
    Passenger ownerPassenger;
    List<Passenger> otherPassengers;
    boolean canceled;

    static { ordersCount = 0; }

    public Order() { ordersCount++; }

    public Order(int agentCode, AircraftCompany flightCompany, boolean roundTrip, double totalCost, long creditCard,
                 List<Flight> flightTo, List<Flight> flightFrom, Passenger ownerPassenger, List<Passenger> otherPassengers) {
        this.agentCode = agentCode;
        this.flightCompany = flightCompany;
        this.roundTrip = roundTrip;
        this.id = ordersCount++;
        this.totalCost = totalCost;
        this.creditCard = creditCard;
        this.flightTo = flightTo;
        this.flightFrom = flightFrom;
        this.ownerPassenger = ownerPassenger;
        this.otherPassengers = otherPassengers;
        this.canceled = false;
    }

    // Getters
    public int getAgentCode() { return this.agentCode; }
    public AircraftCompany getFlightCompany() { return this.flightCompany; }
    public boolean isRoundTrip() { return this.roundTrip; }
    public long getId() { return this.id; }
    public double getTotalCost() { return this.totalCost; }
    public long getCreditCard() { return this.creditCard; }
    public List<Flight> getFlightTo() { return this.flightTo; }
    public List<Flight> getFlightFrom() { return this.flightFrom; }
    public Passenger getOwnerPassenger() { return this.ownerPassenger; }
    public List<Passenger> getOtherPassengers() { return this.otherPassengers; }
    public boolean isCanceled() { return canceled; }

    // Setters
    public void setAgentCode(int agentCode) { this.agentCode = agentCode; }
    public void setFlightCompany(AircraftCompany flightCompany) { this.flightCompany = flightCompany; }
    public void setRoundTrip(boolean roundTrip) { this.roundTrip = roundTrip; }
    public void setId(long id) { this.id = id; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setCreditCard(long creditCard) { this.creditCard = creditCard; }
    public void setFlightTo(List<Flight> flightTo) { this.flightTo = flightTo; }
    public void setFlightFrom(List<Flight> flightFrom) { this.flightFrom = flightFrom; }
    public void setOwnerPassenger(Passenger ownerPassenger) { this.ownerPassenger = ownerPassenger; }
    public void setOtherPassengers(List<Passenger> otherPassengers) { this.otherPassengers = otherPassengers; }
    public void setCanceled(boolean isCanceled) { this.canceled = isCanceled; }

    public boolean addPassenger(Passenger newPassenger) {
        return new OrderRepositoryImpl().addPassenger(this, newPassenger);
    }

    public boolean removePassengerByID(long id) {
        return new OrderRepositoryImpl().removePassengerByID(this, id);
    }

    public void deleteOrder() {
        new OrderRepositoryImpl().deleteOrder(this);
    }

    public void cancelOrder() {
        new OrderRepositoryImpl().deactivate(this);
    }

    @Override
    public String toString() {
        int currency = FlightSingleton.getInstance().getCurrency();
        if (currency == 1) {
            OrderCurrencyAdapterImpl orderCurrencyAdapter = new OrderCurrencyAdapterImpl(this);
            return "Order:\n" +
                    "flightCompany=" + flightCompany +
                    "\nroundTrip=" + roundTrip +
                    "\norderID=" + id +
                    "\ntotalCost=" + orderCurrencyAdapter.getTotalCost() +
                    "\ncreditCard=" + creditCard +
                    "\nflightTo=" + flightTo +
                    "\nflightFrom=" + flightFrom +
                    "\nownerPassenger=" + ownerPassenger +
                    "\notherPassengers=" + otherPassengers;
        }
        return "Order:\n" +
                "flightCompany=" + flightCompany +
                "\nroundTrip=" + roundTrip +
                "\norderID=" + id +
                "\ntotalCost=" + totalCost +
                "\ncreditCard=" + creditCard +
                "\nflightTo=" + flightTo +
                "\nflightFrom=" + flightFrom +
                "\nownerPassenger=" + ownerPassenger +
                "\notherPassengers=" + otherPassengers;
    }
}
