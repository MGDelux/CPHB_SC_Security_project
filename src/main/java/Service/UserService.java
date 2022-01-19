package Service;

import Config.ErrorHandling.UserNotFoundException;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Service.Interfaces.IUserService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;


/**
 * CREATED BY mathias @ 18-11-2021 - 20:00
 **/
public class UserService implements IUserService {
    private static EntityManagerFactory emf;

    @Override
    public BaseUser getUser(String email) {
        emf = EMF_Creator.createEntityManagerFactory();
        try {
            EntityManager em = emf.createEntityManager();
            BaseUser checkUser;
            checkUser = (BaseUser) em.createNativeQuery(
                    "SELECT * FROM USERS where Email = ?", BaseUser.class).setParameter(1, email).getSingleResult();
            if (checkUser.getEmail().equalsIgnoreCase(email)) {
                return checkUser;
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException e) {
            return null;
        }
    }

    @Override
    public BaseUser InternalModifyUser(BaseUser user) {
        emf = EMF_Creator.createEntityManagerFactory();
        try {
            System.out.println("Internal");

            EntityManager em = emf.createEntityManager();
            em.merge(user);
            em.merge(user.getCustomerInfomation());
            em.merge(user.getCustomerInfomation().getAddress());
            System.out.println("Internal user is go");

            return user;
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public BaseUser ModifyUser(BaseUser user) {
        return null;
    }
}
