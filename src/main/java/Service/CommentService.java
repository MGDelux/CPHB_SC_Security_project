package Service;

import Dependencies.EMF_Creator;
import Models.Store.Product;
import Models.Store.ProductComment;
import Models.Users.BaseUser;
import Service.Interfaces.ICommentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * CREATED BY mathias @ 22-11-2021 - 16:54
 **/
public class CommentService implements ICommentService {
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

    @Override
    public void postComment(int rating, Product specificProduct, String comment, BaseUser user) throws Exception {
        ProductComment productComment = new ProductComment(user, comment, rating, specificProduct);
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            List<ProductComment> productComments = specificProduct.getProductComments();
            productComments.add(productComment);
            specificProduct.setProductComments(productComments);
            entityManager.merge(productComment);
            entityManager.merge(specificProduct);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
