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

    @Override
    public String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        System.out.println(base32.encodeToString(bytes));
        return base32.encodeToString(bytes);
    }
    public String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }


    /**
     *
     * Account is the user id in system. Usually it’s user’s email or username. It’s used to label entries within Google Authenticator.
     * Issuer is a company or organization name and is also used for labelling purposes.
     * All dynamic values must be URL encoded.
     * Google Authenticator doesn’t seem to deal with spaces encoded as plus signs. Encoding spaces as %20 seems to work.
     */
    public String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
        try {
            return "otpauth://totp/"
                    + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
                    + "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20")
                    + "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public void createQRCode(String barCodeData, String filePath, int height, int width)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE,
                width, height);
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            MatrixToImageWriter.writeToStream(matrix, "png", out);
        }
    }
}
