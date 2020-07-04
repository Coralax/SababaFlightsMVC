/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;

import model.service.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    // boolean because order might not exist/no orders in the range of dates/agent code...
    public boolean searchByID(){return false;}
    public boolean searchByAgentCode(){return false;}
    public boolean searchByPassenger(){return false;}
    public boolean searchByDate(){return false;}
    public boolean addAPassengerToOrder(){return false;}
    public boolean cancelOrder(){return false;}


}
