package Models.Store;

import Models.Users.BaseUser;
import Models.Users.Permissions;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:10
 **/
@Entity(name = "Product_Comment")

public class ProductComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="comment_id")
    private Long id;
    @NotNull
    @Column(name="timeStamp")
    private String timeAndDateStamp;
    @Column(name="Commenting_User")
    @NotNull
    @ManyToOne(targetEntity = BaseUser.class,cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    private BaseUser commenter;
    @NotNull
    @Column(name="Comment")
    private String comment;
    @OneToOne(targetEntity = ProductRating.class, cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    private ProductRating productRating; // 1 - 5, 5 is max 1 is minimum

    public ProductComment() {

    }
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");


    public ProductComment(@NotNull BaseUser commenter, @NotNull String comment, ProductRating productRating) {
        this.timeAndDateStamp = formatter.format(System.currentTimeMillis());
        this.commenter = commenter;
        this.comment = comment;
        this.productRating = productRating;
    }

    public String getTimeAndDateStamp() {
        return timeAndDateStamp;
    }

    public void setTimeAndDateStamp(String timeAndDateStamp) {
        this.timeAndDateStamp = timeAndDateStamp;
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

    public ProductRating getProductRating() {
        return productRating;
    }

    public void setProductRating(ProductRating productRating) {
        this.productRating = productRating;
    }
}
