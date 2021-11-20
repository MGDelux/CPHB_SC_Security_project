package Persistence;

import Models.Users.BaseUser;
import Service.Interfaces.IUserService;

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

    public BaseUser modifyUser(BaseUser user) {
        return this.IUserService.modifyUser(user);
    }

}
