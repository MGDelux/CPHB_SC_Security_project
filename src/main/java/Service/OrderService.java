package Service;

import Dependencies.EMF_Creator;
import Models.Store.Order;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IOrderService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 26-11-2021 - 14:32
 **/
public class OrderService implements IOrderService {
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

    @Override
    public boolean createOrder(BaseUser user, Order order) {
        if (user.checkForPermission(Permissions.UserPermissions.ADD_TO_BASKET)) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrder(BaseUser user, Order order) {
        return false;
    }
}
