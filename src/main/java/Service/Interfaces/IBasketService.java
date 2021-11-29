package Service.Interfaces;

import Config.ErrorHandling.WebPermissionException;
import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;

import javax.servlet.http.HttpServletRequest;

/**
 * CREATED BY mathias @ 24-11-2021 - 11:23
 **/
public interface IBasketService {
    boolean addProductToBasket(Product product, BaseUser user, HttpServletRequest request) throws WebPermissionException;

    CustomerBasket getProductsInBasket(BaseUser user);

    boolean removeProductFromBasket(int index, BaseUser user, HttpServletRequest request);

    double calculateTotalPrice(HttpServletRequest request);
}
