package Models.Users;

import javax.persistence.*;
import java.io.Serializable;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:06
 **/
@Entity(name = "CustomerInfomation")

public class Customer implements Serializable {
    boolean isCustomer;
    String firstName;
    String lastName;
    @OneToOne(cascade = CascadeType.PERSIST)
    Address address;
    double storeCredit;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Customer(boolean isCustomer, double storeCredit) {
        this.isCustomer = isCustomer;
        this.storeCredit = storeCredit;

    }

    public Customer() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
