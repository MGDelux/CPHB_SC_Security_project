package Service.Interfaces;

import Config.ErrorHandling.UserInternalError;
import Config.ErrorHandling.WebPermissionException;
import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:11
 **/
public interface IRegisterService {
    public boolean CheckIfInSystem(String email, String password) throws Exception;
    public BaseUser registerUser(String email, String password) throws Exception;
}
