package Models.Store;

import Models.Users.BaseUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:10
 **/
@Entity(name = "Product_Comment")

public class ProductComment implements Serializable {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm z");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "comment_id")
    private Long id;
    @NotNull
    @Column(name = "timeStamp")
    private String timeAndDateStamp;
    @NotNull
    @ManyToOne(targetEntity = BaseUser.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_test_id")
    private BaseUser commenter;
    @NotNull
    @Column(name = "Comment")
    private String comment;
    @Size(min = 1, max = 5)
    private int rating;
    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Product product;

    public ProductComment() {

    }


    public ProductComment(@NotNull BaseUser commenter, @NotNull String comment, int productRating, Product product) {
        this.timeAndDateStamp = formatter.format(System.currentTimeMillis());
        this.commenter = commenter;
        this.comment = comment;
        this.rating = productRating;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTimeAndDateStamp() {
        return timeAndDateStamp;
    }

    public void setTimeAndDateStamp(String timeAndDateStamp) {
        this.timeAndDateStamp = timeAndDateStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseUser getCommenter() {
        return commenter;
    }

    public void setCommenter(BaseUser commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }
}
