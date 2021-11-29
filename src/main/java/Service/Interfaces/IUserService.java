package Service.Interfaces;

import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:01
 **/
public interface IUserService {
    BaseUser getUser(String email);

    BaseUser InternalModifyUser(BaseUser user);

    BaseUser ModifyUser(BaseUser user);
}
