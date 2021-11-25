package Persistence;

import Config.ErrorHandling.WebPermissionException;
import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Service.Interfaces.IBasketService;

import javax.servlet.http.HttpServletRequest;

/**
 * CREATED BY mathias @ 24-11-2021 - 15:29
 **/
public class BasketPersistence {
    private final IBasketService basketService;

    public BasketPersistence(IBasketService basketService) {
        this.basketService = basketService;
    }

    public boolean addProductToBasket(Product product, BaseUser user, HttpServletRequest req) throws WebPermissionException {
        return this.basketService.addProductToBasket(product, user, req);
    }

    public CustomerBasket getProductsInBasket(BaseUser user) {
        return this.basketService.getProductsInBasket(user);
    }

    public boolean removeProductFromBasket(int index, BaseUser user,HttpServletRequest request) {
        return this.basketService.removeProductFromBasket(index, user,request);
    }

}
