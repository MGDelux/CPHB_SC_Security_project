package Service.Interfaces;

import Models.Store.Product;
import Models.Users.BaseUser;

import java.util.List;

/**
 * CREATED BY mathias @ 21-11-2021 - 18:42
 **/
public interface IProductService {
    Product createNewProduct(BaseUser user, Product product) throws Exception;

    Product deleteProduct(BaseUser user, Product product);

    Product modifyProduct(BaseUser user, Product product);

    List<Product> getAllProducts();

    Product getSpecificProduct(long product);
}
