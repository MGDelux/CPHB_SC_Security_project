package Persistence;

import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Service.Interfaces.IBasketService;

/**
 * CREATED BY mathias @ 24-11-2021 - 15:29
 **/
public class BasketPersistence {
    private final IBasketService basketService;

    public BasketPersistence(IBasketService basketService) {
        this.basketService = basketService;
    }

    public boolean addProductToBasket(Product product, BaseUser user) {
        return this.basketService.addProductToBasket(product, user);
    }

    public CustomerBasket getProductsInBasket(BaseUser user) {
        return this.basketService.getProductsInBasket(user);
    }

    public boolean removeProductFromBasket(Product product, BaseUser user) {
        return this.basketService.removeProductFromBasket(product, user);
    }

}
