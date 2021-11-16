package Persistence;

import Config.ErrorHandling.UserNotFoundException;
import Models.User;
import Models.Users.BaseUser;
import Persistence.DAO.LoginDao;

public class LoginDaoImpl implements LoginDao {


    @Override
    public boolean verifyCredentials(BaseUser baseUser) throws UserNotFoundException {
        return false;
    }

    @Override
    public boolean login(String password, BaseUser user) throws UserNotFoundException {
        return false;
    }

    @Override
    public void logout(BaseUser user) {

    }
}
