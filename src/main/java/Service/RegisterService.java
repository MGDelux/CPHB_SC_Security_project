package Service;

import Config.ErrorHandling.WebPermissionException;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Models.Users.Customer;
import Models.Users.Permissions;
import Service.Interfaces.IRegisterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:13
 **/
public class RegisterService implements IRegisterService {
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();


    public boolean CheckIfInSystem(String email, String password) throws Exception {
        try {
            EntityManager em = emf.createEntityManager();
            BaseUser checkUser;
            checkUser = (BaseUser) em.createNativeQuery(
                    "SELECT * FROM USERS where Email = ?", BaseUser.class).setParameter(1, email).getSingleResult();
            if (checkUser.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Override
    public BaseUser registerUser(String email, String password) throws Exception {
        EntityManager em = emf.createEntityManager();

        if (email == null || password == null) {
            throw new Exception(); //TODO CUSTOM Exception

        }
        BaseUser NewUser = new BaseUser(email, password);
        List<Permissions> permissions = new ArrayList<>();
        Customer customer = new Customer(true, 2500);
        NewUser.setCustomerInfomation(customer);
        Permissions permissions1 = new Permissions("View Personal Page", Permissions.UserPermissions.VIEW_PERSONAL_USER_PAGE);
        Permissions permissions2 = new Permissions("Add products to basket", Permissions.UserPermissions.ADD_TO_BASKET);
        Permissions permissions3 = new Permissions("Upload profile picture", Permissions.UserPermissions.UPLOAD_PROFILE_PICTURE);
        permissions.add(permissions1);
        permissions.add(permissions2);
        permissions.add(permissions3);
        try {
            NewUser.setUserPermissions(permissions);
            em.getTransaction().begin();
            em.persist(customer);
            em.merge(NewUser);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new WebPermissionException();
        }
        return NewUser;
    }
}

