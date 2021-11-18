package Service;

import org.junit.jupiter.api.Test;

/**
 * CREATED BY mathias @ 18-11-2021 - 12:56
 **/
class RegisterServiceTest {
@Test
    void registerNewUser() throws Exception {
        RegisterService registerService = new RegisterService();
        registerService.registerUser("emailtest", "password");
        System.out.print("USER 1 CREATED");
        System.out.print("\nREDO with same new infomation...");
        registerService.registerUser("new email poggies", "password");
        System.out.print("\nREDO with existing new information...");
    System.out.println("check in system");
  boolean test1 =  registerService.CheckIfInSystem("emailtest", "password");
  boolean test2 =  registerService.CheckIfInSystem("new Email PoGgies", "password");
    boolean test3 =  registerService.CheckIfInSystem("new xadsasdasd PoGgies", "password");
    System.out.println(test1+ " " + test2 + " " + test3);
    }

    @Test
    void checkIfInSystem() throws Exception {
        RegisterService registerService = new RegisterService();

    }
}