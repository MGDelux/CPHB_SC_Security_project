package Service;

import Config.ErrorHandling.WebPermissionException;
import Models.Store.CustomerBasket;
import Models.Store.Product;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IBasketService;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 24-11-2021 - 11:24
 **/
public class BasketService implements IBasketService {
    @Override
    public boolean addProductToBasket(Product product, BaseUser user, HttpServletRequest request) throws WebPermissionException {
        try {
            if (user.checkForPermission(Permissions.UserPermissions.ADD_TO_BASKET)) {
                if (request.getSession().getAttribute("userBasket") == null) {
                    List<Product> productList = new ArrayList<>();
                    productList.add(product);
                    request.getSession().setAttribute("userBasket", new CustomerBasket(productList, user));
                } else {

                    List<Product> productList = new ArrayList<>();
                    CustomerBasket customerBasket = (CustomerBasket) request.getSession().getAttribute("userBasket");
                    productList.addAll(customerBasket.getProducts());
                    productList.add(product);
                    request.getSession().setAttribute("userBasket", new CustomerBasket(productList, user));
                }

            } else throw new WebPermissionException();

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
    public boolean removeProductFromBasket(int index, BaseUser user, HttpServletRequest request) {
        try {
            if (user.checkForPermission(Permissions.UserPermissions.ADD_TO_BASKET)) {

                HttpSession httpSession = request.getSession();
                CustomerBasket currentBasket = (CustomerBasket) httpSession.getAttribute("userBasket");
                List<Product> currentProductList = currentBasket.getProducts();
                currentProductList.remove(index);
                httpSession.setAttribute("userBasket", currentBasket);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public double calculateTotalPrice(HttpServletRequest request) {
        double price = 0;
        try {
            if (request.getSession().getAttribute("userBasket") == null) {
                return 0;
            } else {

                CustomerBasket customerBasket = (CustomerBasket) request.getSession().getAttribute("userBasket");
                for (Product p : customerBasket.getProducts()) {
                    price = price + p.getProductPrice();
                    request.getSession().setAttribute("TotalPrice",price);
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return price;
    }
}