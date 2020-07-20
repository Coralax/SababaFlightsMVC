package model.filemanager;

import model.objects.Order;

import java.util.Set;

public class OrderFileManager extends FileManager<Order> {

    private static OrderFileManager orderFileManagerInst = null;
    public Set<Order> orderSet;

    private OrderFileManager() {
        super("src/data/orders.json");
        orderSet = this.read(Order.class);
    }

    public static OrderFileManager getInstance() {
        if (orderFileManagerInst == null)
            orderFileManagerInst = new OrderFileManager();

        return orderFileManagerInst;
    }

}
