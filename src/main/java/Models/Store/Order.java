package Models.Store;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:19
 **/
@Entity(name = "Orders")

public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private double orderID;
    @OneToOne(targetEntity = CustomerBasket.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private CustomerBasket basket;

    public Order(CustomerBasket orderInformation) {
        this.basket = orderInformation;
    }

    public Order() {

    }

    public CustomerBasket getBasket() {
        return basket;
    }
}
