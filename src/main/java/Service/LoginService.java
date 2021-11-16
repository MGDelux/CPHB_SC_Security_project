package Service;

import Config.ErrorHandling.UserNotFoundException;
import Models.Users.BaseUser;
import Persistence.DAO.LoginDao;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 16-11-2021 - 10:12
 **/
public class LoginService implements LoginDao {
    private static EntityManagerFactory emf;

    @Override
    public boolean verifyCredentials(BaseUser baseUser) throws UserNotFoundException {
        return false;
    }

    @Override
    public boolean login(String pass,BaseUser user) throws UserNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(BaseUser.class,user.getId());
        }catch (Exception e){
            throw new UserNotFoundException();
        }
        return BCrypt.checkpw(pass,user.getSaltedPassword());
    }



    @Override
    public void logout(BaseUser user) {

    }
}
