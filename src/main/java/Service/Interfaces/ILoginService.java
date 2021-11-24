package Service.Interfaces;

import Models.Users.BaseUser;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {
     boolean verifyCredentials(BaseUser user, String password);
     boolean logout(BaseUser user, HttpServletRequest request);
     void SetLoggedin(BaseUser user) throws Exception;
     boolean isLoggedIn(BaseUser user,HttpServletRequest request );
}
