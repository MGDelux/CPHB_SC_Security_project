package Service;

import Config.ErrorHandling.WebPermissionException;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Models.Users.Customer;
import Models.Users.Permissions;
import Service.Interfaces.IRegisterService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.binary.Base32;

import javax.crypto.SecretKey;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
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
    public BaseUser registerUser(String email, String password,String SecretKey) throws Exception {
        EntityManager em = emf.createEntityManager();

        if (email == null || password == null) {
            throw new Exception(); //TODO CUSTOM Exception

        }
        BaseUser NewUser = new BaseUser(email, password);
        NewUser.setSecretKey(SecretKey);
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
    public String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        System.out.println(base32.encodeToString(bytes));
        return base32.encodeToString(bytes);
    }

    public String getGoogleAuthenticatorBarCode(String SecretKey, String email) {
       String issuer = "Solidcode";
        try {
            return "otpauth://totp/"
                    + URLEncoder.encode(issuer + ":" + email, "UTF-8").replace("+", "%20")
                    + "?secret=" + URLEncoder.encode(SecretKey, "UTF-8").replace("+", "%20")
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

