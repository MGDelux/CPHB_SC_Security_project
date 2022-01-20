package Persistence;

import Models.Users.BaseUser;
import Service.Interfaces.IUserService;

import javax.crypto.SecretKey;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:07
 **/
public class UserPresistence {
    private final IUserService IUserService;


    public UserPresistence(Service.Interfaces.IUserService iUserService) {
        IUserService = iUserService;
    }

    public BaseUser getUser(String email) {
        return this.IUserService.getUser(email);
    }

    public BaseUser InternalModifyUser(BaseUser user) {
        return this.IUserService.InternalModifyUser(user);
    }

    public BaseUser ModifyUser(BaseUser user) {
        return this.IUserService.ModifyUser(user);
    }

    public BaseUser getSecret(String SecretKey) {return this.IUserService.getSecret(SecretKey);}
}
