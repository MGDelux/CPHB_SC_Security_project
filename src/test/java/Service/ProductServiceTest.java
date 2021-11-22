package Service;

import Dependencies.EMF_Creator;
import Models.Store.Product;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CREATED BY mathias @ 22-11-2021 - 13:36
 **/
class ProductServiceTest {
    private static EntityManagerFactory emf;

    @Test
    void createNewProduct() {
        emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Product product1 = new Product("ProductName1", "ProductDescription1", 21, 5);
        Product product2 = new Product("ProductName2", "ProductDescription2", 23, 5);
        Product product3 = new Product("ProductName3", "ProductDescription3", 24, 5);
        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.getTransaction().commit();

    }
}