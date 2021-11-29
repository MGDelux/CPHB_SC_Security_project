package Persistence;

import Models.Store.Product;
import Models.Users.BaseUser;
import Service.Interfaces.IProductService;

import java.util.List;

/**
 * CREATED BY mathias @ 21-11-2021 - 18:25
 **/
public class ProductPerstistence {
    private final IProductService productService;

    public ProductPerstistence(IProductService productService) {
        this.productService = productService;
    }

    public Product createNewProduct(BaseUser user, Product product) throws Exception {
        return productService.createNewProduct(user, product);
    }

    public Product deleteProduct(BaseUser user, Product product) {
        return productService.deleteProduct(user, product);
    }

    public Product modifyProduct(BaseUser user, Product product) {
        return productService.modifyProduct(user, product);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public Product getSpecificProduct(long product) {
        return productService.getSpecificProduct(product);
    }


}
