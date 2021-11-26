package Persistence;

import Models.Store.Order;
import Models.Users.BaseUser;
import Service.Interfaces.IOrderService;

/**
 * CREATED BY mathias @ 26-11-2021 - 14:33
 **/
public class OrderPersistence {
    private final IOrderService orderService;

    public OrderPersistence(IOrderService orderService) {
        this.orderService = orderService;
    }

    public  boolean createOrder(BaseUser user, Order order){
        return this.orderService.createOrder(user, order);
    }
    public   boolean deleteOrder(BaseUser user, Order order){
        return  this.deleteOrder(user, order);
    }

}
