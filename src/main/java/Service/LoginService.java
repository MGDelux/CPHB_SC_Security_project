package Service;

import Config.ErrorHandling.UserNotFoundException;
import Models.Users.BaseUser;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 16-11-2021 - 10:12
 **/
public class LoginService  {
    private static EntityManagerFactory emf;

    public boolean verifyCredentials(BaseUser baseUser) throws UserNotFoundException {
        return false;
    }

    public boolean login(String pass,BaseUser user) throws UserNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(BaseUser.class,user.getId());
        }catch (Exception e){
            throw new UserNotFoundException();
        }
        return BCrypt.checkpw(pass,user.getSaltedPassword());
    }




    public void logout(BaseUser user) {

    }
}
