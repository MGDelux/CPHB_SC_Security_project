package Service;

import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Service.Interfaces.IBasketService;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 24-11-2021 - 11:24
 **/
public class BasketService implements IBasketService {
    @Override
    public boolean addProductToBasket(Product product, BaseUser user) {
        List<Product> productList = new ArrayList();
        productList.add(product); //temp
       CustomerBasket customerBasket = new CustomerBasket(productList,user);
        System.out.println(customerBasket);
        try {
            if (1 == 1) {
                //bla
            }
        } finally {
            return true;
        }

    }

    @Override
    public CustomerBasket getProductsInBasket(BaseUser user) {
        return null;
    }

    @Override
    public boolean removeProductFromBasket(Product product, BaseUser user) {
        return false;
    }
}
