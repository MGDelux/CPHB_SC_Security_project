package Service.Interfaces;

import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:01
 **/
public interface IUserService {
    public BaseUser getUser(String email);
    public BaseUser modifyUser(BaseUser user);
}
