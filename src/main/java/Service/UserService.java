package Service;

import Config.ErrorHandling.UserNotFoundException;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Service.Interfaces.IUserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:00
 **/
public class UserService implements IUserService {
    private static EntityManagerFactory emf;

    @Override
    public BaseUser getUser(String email) {
        emf = EMF_Creator.createEntityManagerFactory();
        try {
            System.out.println("getting user");
            EntityManager em = emf.createEntityManager();
            BaseUser checkUser;
            checkUser = (BaseUser) em.createNativeQuery(
                    "SELECT * FROM USERS where Email = ?", BaseUser.class).setParameter(1, email).getSingleResult();
            System.out.println(checkUser.toString());
            if (checkUser.getEmail().equalsIgnoreCase(email)) {
                return checkUser;
            } else {
                System.out.println("not found user");
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException e) {
            return null;
        }
    }

    @Override
    public BaseUser modifyUser(BaseUser user) {
        return null;
    }
}
