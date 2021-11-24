package Models.Store;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:13
 **/
@Entity(name = "Product_Rating")
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @Size(min = 1,max = 5)
    int rating;
    @OneToOne(targetEntity = ProductComment.class, cascade = CascadeType.PERSIST,fetch =  FetchType.EAGER)
    ProductComment productComment;

    public ProductRating() {

    }

    public ProductRating(@Size(min = 1, max = 5) int rating) {
        this.rating = rating;

    }
}
