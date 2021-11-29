package Service;

import Dependencies.EMF_Creator;
import Models.Store.Product;
import Models.Store.ProductComment;
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
        Product product1 = new Product("Chocolate Cupcake", "Base chocolate cupcke", 18, 5);
        Product product2 = new Product("Peanut Cupcake", "filled with nut", 25, 5);
        Product product3 = new Product("Strawberry Cupcake", "ProductDescription3", 50, 5);
        Product product5 = new Product("Strawberry Chocolate Cupcake", "strawberry and chocolate ", 55, 5);
        Product product6 = new Product("Bing Chilling Cupcake", "nr1 cupcake i CCP ", 100, 5);
        Product product7 = new Product("Ali Supreme Cupcake", "Den bedste cupcake nogleside lavet kun med de bedste ingredienser ", 69, 5);
        Product product8 = new Product("Sur Janus Cupcake", "fyldt med salt og burger sovs", 69, 5);

        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product5);
        em.persist(product6);
        em.persist(product7);
        em.persist(product8);
        em.getTransaction().commit();

    }
}