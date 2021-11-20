package Models.Store;

import Models.Users.BaseUser;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:10
 **/
@Entity(name = "Product_Comments")
public class ProductComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="Product_comments_id")
    private Long id;
    @JoinColumn(name = "test_id")
    @NotNull
    @OneToOne(targetEntity = Product.class,cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    private Product product;
    @OneToMany(targetEntity = ProductComment.class,cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    List<ProductComment> productCommentList;

    public ProductComments() {
    }

    public ProductComments(@NotNull Product product, List<ProductComment> productCommentList) {
        this.product = product;
        this.productCommentList = productCommentList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductComment> getProductCommentList() {
        return productCommentList;
    }

    public void setProductCommentList(List<ProductComment> productCommentList) {
        this.productCommentList = productCommentList;
    }
}
