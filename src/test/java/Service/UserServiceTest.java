package Service;

import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CREATED BY Emil @ 16-01-2022 - 14:06
 **/
class UserServiceTest {

    @Test
    void generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        System.out.println(base32.encodeToString(bytes));

    }

}

//V6FFBYBE54UWWEJY6YPZHY23PT2C6SCF