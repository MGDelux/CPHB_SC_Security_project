package Models.Store;

import Models.Users.BaseUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:18
 **/
@Entity(name = "UserBasket")
public class CustomerBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="basket_id")
    private Long id;
    @OneToMany()
    List<Product> products;
    @OneToOne(targetEntity = BaseUser.class, cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    BaseUser customer;

    double totalPrice;

    public CustomerBasket(List<Product> products, BaseUser customer) {
        this.products = products;
        this.customer = customer;
    }

    public CustomerBasket() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BaseUser getCustomer() {
        return customer;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCustomer(BaseUser customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerBasket{" +
                "products=" + products +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
