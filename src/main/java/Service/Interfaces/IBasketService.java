package Service.Interfaces;

import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Models.Users.Customer;

/**
 * CREATED BY mathias @ 24-11-2021 - 11:23
 **/
public interface IBasketService {
    boolean addProductToBasket(Product product, BaseUser user);
    CustomerBasket getProductsInBasket(BaseUser user);
    boolean removeProductFromBasket(Product product, BaseUser user);

}
