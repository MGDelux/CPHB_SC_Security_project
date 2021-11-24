package Service;

import Dependencies.EMF_Creator;
import Models.Store.Product;
import Models.Store.ProductComment;
import Models.Store.ProductRating;
import Models.Users.BaseUser;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 22-11-2021 - 13:36
 **/
    class ProductServiceTest {
    private static EntityManagerFactory emf;

    @Test
    void createNewProduct() {
        List<ProductComment> productCommentsList = new ArrayList();

        emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        BaseUser user = new BaseUser("commenter@comment.com","123");
        ProductRating rating = new ProductRating(5);
        ProductComment comment = new ProductComment(user,"amazing product!",rating);
        Product product1 = new Product("ProductName1", "ProductDescription1", 21, 5);
       productCommentsList.add(comment);
       product1.setProductComments(productCommentsList);
        Product product2 = new Product("ProductName2", "ProductDescription2", 23, 5);
        Product product3 = new Product("ProductName3", "ProductDescription3", 24, 5);
        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.getTransaction().commit();

    }
}