package Models.Store;

import Models.Users.BaseUser;

import java.util.List;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:18
 **/
public class CustomerBasket {
    List<Product> products;
    BaseUser customer;

    double totalPrice;

    public CustomerBasket(List<Product> products, BaseUser customer, double totalPrice) {
        this.products = products;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }
}
