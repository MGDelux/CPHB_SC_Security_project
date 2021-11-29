package Service.Interfaces;

import Models.Store.Order;
import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 26-11-2021 - 14:31
 **/
public interface IOrderService {
    boolean createOrder(BaseUser user, Order order);

    boolean deleteOrder(BaseUser user, Order order);

}
