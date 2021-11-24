package Service;

import Config.ErrorHandling.UserNotFoundException;
import Dependencies.EMF_Creator;
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
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

    @Override
    public boolean verifyCredentials(BaseUser user, String password) {
        return BCrypt.checkpw(password, user.getSaltedPassword());
    }

    @Override
    public boolean logout(BaseUser user, HttpServletRequest request) {
        return false;
    }

    @Override
    public void SetLoggedin(BaseUser user) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("set login");
            user.setLoggedIn(true);
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }catch (Exception e){
            throw new Exception();
        }

    }

    @Override
    public boolean isLoggedIn(BaseUser user, HttpServletRequest request) {
        try {
            if (user.isLoggedIn() && (Boolean.valueOf(request.getSession().getAttribute("loggedIn").toString()))) {
                return true;
            } else return false;
        }catch (NullPointerException e){
            request.setAttribute("LogInError", "Please login to add item to your basket..");
            return false;
        }
    }


}
