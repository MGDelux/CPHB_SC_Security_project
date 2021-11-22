package Service.Interfaces;

import Models.Users.BaseUser;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {
     boolean verifyCredentials(BaseUser user, String password);
     boolean logout(BaseUser user, HttpServletRequest request);
     boolean isLoggedin(BaseUser user, HttpServletRequest request);
}
