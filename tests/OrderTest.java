import controller.OrderController;
import model.objects.Order;
import model.objects.Passenger;
import model.repository.PassengerRepositoryImpl;
import model.service.OrderService;
import model.singletons.PassengerSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class OrderTest {


    @Test
    public void  failGetOrderByIdTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(28);
        assertNull(order);

    }

    @Test
    public void  passGetOrderByIdTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        long passengerID = order.getOwnerPassengerID();

        assertEquals(0,passengerID);

    }

    @Test
    public void addPassengerToOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        PassengerSingleton passengerSingleton = PassengerSingleton.getInstance();
        Passenger passenger = new PassengerRepositoryImpl().getPassengerByID(3);
        boolean success = orderController.addPassengerToOrder(order, passenger.getId());
        assertTrue(success);

    }

    @Test
    public void removePassengerByIDTest(){
        OrderController orderController = new OrderController();
        OrderService orderService = new OrderService();
        Order order = orderController.getOrderByID(80734);
        boolean isDelete = orderService.removePassengerByID( order,order.getOtherPassengersIDs().get(0));
//        boolean isDelete = orderService.removePassengerByID( order,654654654);
        assertTrue(isDelete);
    }

    @Test
    public void deleteOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean isDeleted = orderController.deleteOrder(order);
        assertTrue(isDeleted);
    }

    @Test
    public void reActivateOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean reActive = orderController.reActivateOrder(order);
        assertTrue(reActive);

    }

    @Test
    public void deactivate() {
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean deActive = orderController.cancelOrder(order);
        assertTrue(deActive);
    }

}
