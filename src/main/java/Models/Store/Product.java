package Models.Store;

/**
 * CREATED BY mathias @ 14-11-2021 - 14:07
 **/
public class Product{

    private int productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productsInStock;
    private byte[] ProductPicture;

    public Product(){
    }

    public Product(int productID, String productName, String productDescription, double productPrice, int productsInStock){
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productsInStock = productsInStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
}
