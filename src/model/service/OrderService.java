package model.service;

import model.repository.OrderRepository;
import model.repository.OrderRepositoryImpl;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = new OrderRepositoryImpl();
    }
}
