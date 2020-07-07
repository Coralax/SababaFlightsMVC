package model.service;

import model.objects.Flight;
import model.objects.Order;
import model.objects.Passenger;
import model.repository.FlightRepositoryImpl;
import model.repository.OrderRepositoryImpl;
import model.singletons.OrderSingleton;

import java.util.List;
import java.util.Set;

public class OrderService {

    private OrderRepositoryImpl orderRepository;
    private OrderSingleton orderSingletonInstance;
    private FlightRepositoryImpl flightRepository;
    private Set<Order> orders;

    public OrderService() {
        orderSingletonInstance = OrderSingleton.getInstance();
        orders = orderSingletonInstance.orderSet;
        orderRepository = new OrderRepositoryImpl();
        flightRepository=new FlightRepositoryImpl();
    }


    //FINISH THIS ORDER
    public void makeNewOrder(int filghtID, Passenger passenger)
    {
        System.out.println("Got into Order service makeNewOrder");
        Flight flight=flightRepository.getFlightByID(filghtID);
    }
    public void makeNewOrder(int[] filghtID, Passenger passenger)
    {
        System.out.println("Got into Order service makeNewOrder");

    }

    public Order getOrderByID(long orderID) {
        return orderSingletonInstance.getOrderByID(orderID);
    }

    public Set<Order> getOrdersByAgentCode(long agentCode) {
        return orderSingletonInstance.getOrdersByAgentCode(agentCode);
    }

    public Set<Order> getOrdersByPassengerID(long passengerID) {
        return orderSingletonInstance.getOrdersByPassengerID(passengerID);
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

}