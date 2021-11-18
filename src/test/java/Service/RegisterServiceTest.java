package Service;

import Config.ErrorHandling.UserInternalError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CREATED BY mathias @ 18-11-2021 - 12:56
 **/
class RegisterServiceTest {

    @Test
    void registerNewUser() throws Exception {
        RegisterService registerService = new RegisterService();
        registerService.registerNewUser("emailtest", "password");
        System.out.print("USER 1 CREATED");
        System.out.print("\nREDO with same new infomation...");
        registerService.registerNewUser("new email poggies", "password");
        System.out.print("\nREDO with existing new information...");

        registerService.registerNewUser("emailtest", "password");

    }
}