package model.objects;

import model.adapter.OrderCurrencyAdapterImpl;
import model.repository.OrderRepositoryImpl;
import model.singletons.FlightSingleton;

import java.util.List;

public class Order {

    static int ordersCount;
    int agentCode;
    int flightCompanyID;
    boolean roundTrip;
    long id;
    double totalCost;
    long creditCard;
    List<Long> flightToIDs;
    List<Long> flightFromIDs;
    int ownerPassengerID;
    List<Long> otherPassengersIDs;
    boolean canceled;

    static { ordersCount = 0; }

    public Order() { ordersCount++; }

    public Order(int agentCode, int flightCompanyID, boolean roundTrip, double totalCost, long creditCard,
                 List<Long> flightToIDs, List<Long> flightFromIDs, int ownerPassengerID, List<Long> otherPassengersIDs) {
        this.agentCode = agentCode;
        this.flightCompanyID = flightCompanyID;
        this.roundTrip = roundTrip;
        this.id = ordersCount++;
        this.totalCost = totalCost;
        this.creditCard = creditCard;
        this.flightToIDs = flightToIDs;
        this.flightFromIDs = flightFromIDs;
        this.ownerPassengerID = ownerPassengerID;
        this.otherPassengersIDs = otherPassengersIDs;
        this.canceled = false;
    }

    // Getters
    public int getAgentCode() { return this.agentCode; }
    public int getFlightCompany() { return this.flightCompanyID; }
    public boolean isRoundTrip() { return this.roundTrip; }
    public long getId() { return this.id; }
    public double getTotalCost() { return this.totalCost; }
    public long getCreditCard() { return this.creditCard; }
    public List<Long> getFlightTo() { return this.flightToIDs; }
    public List<Long> getFlightFrom() { return this.flightFromIDs; }
    public int getOwnerPassengerID() { return this.ownerPassengerID; }
    public List<Long> getOtherPassengersIDs() { return this.otherPassengersIDs; }
    public boolean isCanceled() { return canceled; }

    // Setters
    public void setAgentCode(int agentCode) { this.agentCode = agentCode; }
    public void setFlightCompany(int flightCompanyID) { this.flightCompanyID = flightCompanyID; }
    public void setRoundTrip(boolean roundTrip) { this.roundTrip = roundTrip; }
    public void setId(long id) { this.id = id; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setCreditCard(long creditCard) { this.creditCard = creditCard; }
    public void setFlightTo(List<Long> flightToIDs) { this.flightToIDs = flightToIDs; }
    public void setFlightFrom(List<Long> flightFromIDs) { this.flightFromIDs = flightFromIDs; }
    public void setOwnerPassengerID(int ownerPassengerID) { this.ownerPassengerID = ownerPassengerID; }
    public void setOtherPassengersIDs(List<Long> otherPassengersIDs) { this.otherPassengersIDs = otherPassengersIDs; }
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
                    "flightCompany=" + flightCompanyID +
                    "\nroundTrip=" + roundTrip +
                    "\norderID=" + id +
                    "\ntotalCost=" + orderCurrencyAdapter.getTotalCost() +
                    "\ncreditCard=" + creditCard +
                    "\nflightTo=" + flightToIDs +
                    "\nflightFrom=" + flightFromIDs +
                    "\nownerPassenger=" + ownerPassengerID +
                    "\notherPassengers=" + otherPassengersIDs;
        }
        return "Order:\n" +
                "flightCompany=" + flightCompanyID +
                "\nroundTrip=" + roundTrip +
                "\norderID=" + id +
                "\ntotalCost=" + totalCost +
                "\ncreditCard=" + creditCard +
                "\nflightTo=" + flightToIDs +
                "\nflightFrom=" + flightFromIDs +
                "\nownerPassenger=" + ownerPassengerID +
                "\notherPassengers=" + otherPassengersIDs;
    }
}
