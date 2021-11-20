package Service;

import Config.ErrorHandling.UserNotFoundException;
import Models.Users.BaseUser;
import Service.Interfaces.ILoginService;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

/**
 * CREATED BY mathias @ 16-11-2021 - 10:12
 **/
public class LoginService implements ILoginService {
    private static EntityManagerFactory emf;

    @Override
    public boolean verifyCredentials(BaseUser user, String password) {
      return BCrypt.checkpw(password,user.getSaltedPassword());
    }

    @Override
    public boolean logout(BaseUser user, HttpServletRequest request) {
        return false;
    }

    @Override
    public boolean isLoggedin(BaseUser user, HttpServletRequest request) {
        return false;
    }


}
