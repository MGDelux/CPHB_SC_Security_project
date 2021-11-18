package Service.Interfaces;

import Config.ErrorHandling.UserInternalError;
import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:11
 **/
public interface IRegisterService {
    public BaseUser registerNewUser(String email, String password) throws Exception;
}
