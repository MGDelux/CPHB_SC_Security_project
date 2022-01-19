package Service.Interfaces;

import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:11
 **/
public interface IRegisterService {
    boolean CheckIfInSystem(String email, String password) throws Exception;

    BaseUser registerUser(String email, String password, String SecretKey) throws Exception;

    String generateSecretKey();

    String getGoogleAuthenticatorBarCode(String SecretKey, String email);


}
