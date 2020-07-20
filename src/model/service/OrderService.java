package model.service;

import model.objects.Order;
import model.objects.Passenger;
import model.repository.FlightRepositoryImpl;
import model.repository.OrderRepositoryImpl;
import model.filemanager.FlightFileManager;
import model.filemanager.OrderFileManager;
import model.filemanager.PassengerFileManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderService {

    private OrderRepositoryImpl orderRepository;
    private OrderFileManager orderSingletonInstance;
    private FlightRepositoryImpl flightRepository;
    private Set<Order> orders;

    public OrderService() {
        orderSingletonInstance = OrderFileManager.getInstance();
        orders = orderSingletonInstance.orderSet;
        orderRepository = new OrderRepositoryImpl();
        flightRepository=new FlightRepositoryImpl();
    }

    public Order getOrderByID(long orderID) {
        return orderRepository.getOrderById(orderID);
    }

    public Set<Order> getOrdersByAgentCode(long agentCode) {
        return orderRepository.getOrdersByAgentCode(agentCode);
    }

    public Set<Order> getOrdersByPassengerID(long passengerID) {
        return orderRepository.getOrdersByPassengerID(passengerID);
    }

    public boolean addPassengerToOrder(Order order, long passengerID) {
        return orderRepository.addPassenger(order, passengerID);
    }

    public boolean removePassengerByID(Order order, long passengerID) {
        return orderRepository.removePassengerByID(order, passengerID);
    }

    public boolean cancelOrder(Order order) {
        return orderRepository.deactivate(order);
    }

    public boolean reActivateOrder(Order order) {
        return orderRepository.activate(order);
    }

    public boolean deleteOrder(Order order) {
        return orderRepository.deleteOrder(order);
    }

    public void makeNewOrder(long agentCode,String creditCard, List<Long> flightToIDs, List<Long> flightFromIDs, int seatsCount,
                             Passenger ownerPassenger, List<Passenger> otherPassengers, boolean isMeal, boolean isSuitcase, int numOfPassegers) {
        // Process order data
        double totalPrice = 0;
        for (long flightID : flightToIDs)
            totalPrice += flightRepository.getFlightPriceById(flightID);
        if (flightFromIDs != null) {
            for (long flightId : flightFromIDs)
                totalPrice += flightRepository.getFlightPriceById(flightId);
        }
        if (isMeal)
            totalPrice += 25;
        if(isSuitcase)
            totalPrice += 25;
        totalPrice *= numOfPassegers;

        long ownerPassengerID = ownerPassenger.getId();
        List<Long> otherPassengersIDs = new ArrayList<>();
        for (Passenger otherPassenger : otherPassengers)
            otherPassengersIDs.add(otherPassenger.getId());

        // Decrease amount of remaining seats
        for (long flightID : flightToIDs)
            flightRepository.decreaseSeats(flightID, seatsCount);
        if (flightFromIDs != null) {
            for (long flightId : flightFromIDs)
                flightRepository.decreaseSeats(flightId, seatsCount);
        }

        // Create the order itself
        Order newOrder = new Order(agentCode, creditCard, totalPrice, flightToIDs, flightFromIDs, ownerPassengerID, otherPassengersIDs,isMeal,isSuitcase);
        OrderFileManager.getInstance().orderSet.add(newOrder);
        PassengerFileManager.getInstance().saveSet(PassengerFileManager.getInstance().passengerSet);
        FlightFileManager.getInstance().saveSet(FlightFileManager.getInstance().flightSet);
        OrderFileManager.getInstance().saveSet(OrderFileManager.getInstance().orderSet);
        System.out.println( "\n"+"Order with ID <" +newOrder.getId()+"> created successfully!"+"\n");
    }
}