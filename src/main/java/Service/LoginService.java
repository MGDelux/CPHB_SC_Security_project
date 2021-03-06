package Service;

import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Service.Interfaces.ILoginService;
import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void SetLoggedin(BaseUser user, boolean status) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            user.setLoggedIn(status);
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception();
        }

    }

    @Override
    public boolean isLoggedIn(BaseUser user, HttpServletRequest request) {
        try {
            request.changeSessionId();
            return user.isLoggedIn() && (Boolean.parseBoolean(request.getSession().getAttribute("loggedIn").toString()));

        } catch (Exception e) {

            request.setAttribute("LogInError", "Please login to add item to your basket..");
            return false;
        }
    }

    @Override
    public boolean reAuthUser(BaseUser user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        long timePassed = (long) request.getSession().getAttribute("loginTime");
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - timePassed;
        //10min 600000ms
        if (timeElapsed >= 600000) {
            request.getSession().setAttribute("doReAuth", true);
            response.sendRedirect(request.getContextPath() + "/authenticate");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean ForceReAuth(BaseUser user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("doReAuth", true);
        response.sendRedirect(request.getContextPath() + "/authenticate");
        return true;
    }

    @Override
    public String getTOTPCode(String SecretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(SecretKey);
        String hexKey = Hex.encodeHexString(bytes);
        System.out.println(TOTP.getOTP(hexKey));
        return TOTP.getOTP(hexKey);
    }


}
