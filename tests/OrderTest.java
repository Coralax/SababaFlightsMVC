import controller.OrderController;
import model.filemanager.PassengerFileManager;
import model.objects.Order;
import model.objects.Passenger;
import model.repository.PassengerRepositoryImpl;
import model.service.OrderService;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void  failGetOrderByIdTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(200000);
        assertNull(order);

    }


    @Test
    public void addPassengerToOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(1);
        PassengerFileManager passengerSingleton = PassengerFileManager.getInstance();
        Passenger passenger = new PassengerRepositoryImpl().getPassengerByID(3);
        boolean success = orderController.addPassengerToOrder(order, passenger.getId());
        assertTrue(success);

    }

    @Test
    public void removePassengerByIDTest(){
        OrderController orderController = new OrderController();
        OrderService orderService = new OrderService();
        Order order = orderController.getOrderByID(1);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean isDelete = orderService.removePassengerByID(order,order.getOtherPassengersIDs().get(0));
        assertTrue(isDelete);
    }

    @Test
    public void deactivate() {
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(2);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean deActive = orderController.cancelOrder(order);
        assertTrue(deActive);
    }

    @Test
    public void reActivateOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(1);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean reActive = orderController.reActivateOrder(order);
        assertTrue(reActive);
    }

    @Test
    public void deleteOrderTest(){
        OrderController orderController = new OrderController();
        Order order = orderController.getOrderByID(3);
        InputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);
        boolean isDeleted = orderController.deleteOrder(order);
        assertTrue(isDeleted);
    }

}
