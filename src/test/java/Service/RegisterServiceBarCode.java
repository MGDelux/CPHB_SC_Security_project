package Service;


import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * CREATED BY Emil @ 17-01-2022 - 12:28
 **/
class RegisterServiceBarCode {

    @Test
    String getGoogleAuthenticatorBarCode() {
        String SecretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
        String email = "test@gmail.com";
        String companyName = "My Awesome Company";
        String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(SecretKey, email, companyName);
        System.out.println(barCodeUrl);

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
    }
