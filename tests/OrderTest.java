import controller.OrderController;
import model.objects.Order;
import model.objects.Passenger;
import model.service.OrderService;
import model.singletons.PassengerSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OrderTest {


    @Test
    public void  failGetOrderByIdTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(034);
        assertEquals(null,order);

    }
    @Test
    public void  passGetOrderByIdTest(){ // TODO: Check why failed null
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        Passenger passenger = order.getOwnerPassenger();

        assertEquals(0,passenger.getId());

    }

    @Test
    public void addPassengerToOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        PassengerSingleton passengerSingleton = PassengerSingleton.getInstance();
        Passenger passenger = passengerSingleton.getPassengerByID(3);
        boolean success = orderController.addPassengerToOrder(order, passenger.getId());
        assertEquals(true,success);

    }

    @Test
    public void removePassengerByIDTest(){
        OrderController orderController = new OrderController();
        OrderService orderService = new OrderService();
        Order order = orderController.getOrderByID(80734);
        boolean isDelete = orderService.removePassengerByID( order,order.getOtherPassengers().get(0).getId());
//        boolean isDelete = orderService.removePassengerByID( order,654654654);
        assertEquals(true,isDelete);
    }
    @Test
    public void deleteOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean isDeleted = orderController.deleteOrder(order);
        assertEquals(true,isDeleted);
    }
    @Test
    public void reActivateOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(80734);

        boolean reActive = orderController.reActivateOrder(order);
        assertEquals(true,reActive);

    }



}
