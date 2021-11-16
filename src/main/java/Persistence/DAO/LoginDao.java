package Persistence.DAO;

import Config.ErrorHandling.UserNotFoundException;
import Models.Users.BaseUser;


public interface LoginDao {
    public boolean verifyCredentials(BaseUser baseUser) throws UserNotFoundException;
    public boolean login(String password,BaseUser user) throws UserNotFoundException;
    public void logout(BaseUser user);
}
