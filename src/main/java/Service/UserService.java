package Service;

import Models.Users.BaseUser;
import Service.Interfaces.IUserService;

import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:00
 **/
public class UserService implements IUserService {
    private static EntityManagerFactory emf;

    @Override
    public BaseUser getUser(String email) {
        return null;
    }

    @Override
    public BaseUser modifyUser(BaseUser user) {
        return null;
    }
}
