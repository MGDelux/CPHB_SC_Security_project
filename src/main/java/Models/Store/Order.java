package Models.Store;


/**
 * CREATED BY mathias @ 14-11-2021 - 14:19
 **/
public class Order {
    double orderID;
    CustomerBasket orderInformation;

    public Order(double orderID, CustomerBasket orderInformation) {
        this.orderID = orderID;
        this.orderInformation = orderInformation;
    }
}
