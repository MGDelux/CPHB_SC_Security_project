package Service;

import Config.ErrorHandling.WebPermissionException;
import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IBasketService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 24-11-2021 - 11:24
 **/
public class BasketService implements IBasketService {
    @Override
    public boolean addProductToBasket(Product product, BaseUser user, HttpServletRequest request) throws WebPermissionException {

        try {
            if (user.checkForPermission(Permissions.UserPermissions.ADD_TO_BASKET )) {
                List<Product> productList = new ArrayList();
                productList.add(product); //temp
                if (request.getSession().getAttribute("userBasket") != null) {
                    CustomerBasket customerBasket = (CustomerBasket) request.getSession().getAttribute("userBasket");
                    productList.addAll(customerBasket.getProducts());
                    productList.add(product);
                }

                request.getSession().setAttribute("userBasket", new CustomerBasket(productList, user));
            }else throw new WebPermissionException();

        } catch (Exception e) {
            return false;
        }

        return true;
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
