package Persistence;

import Service.Interfaces.IProductService;

/**
 * CREATED BY mathias @ 21-11-2021 - 18:25
 **/
public class ProductPerstistence {
    private final IProductService productService;

    public ProductPerstistence(IProductService productService) {
        this.productService = productService;
    }
}
