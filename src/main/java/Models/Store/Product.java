package Models.Store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:07
 **/
@Entity(name = "Products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productsInStock;
    private byte[] ProductPicture;

    public Product(){
    }

    public Product( String productName, String productDescription, double productPrice, int productsInStock){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productsInStock = productsInStock;
    }

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductsInStock() {
        return productsInStock;
    }

    public void setProductsInStock(int productsInStock) {
        this.productsInStock = productsInStock;
    }

    public byte[] getProductPicture() {
        return ProductPicture;
    }

    public void setProductPicture(byte[] productPicture) {
        ProductPicture = productPicture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productsInStock=" + productsInStock +
                ", ProductPicture=" + Arrays.toString(ProductPicture) +
                '}';
    }
}
