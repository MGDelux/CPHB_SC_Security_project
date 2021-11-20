package Service.Interfaces;

import Models.Users.BaseUser;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {
    public boolean verifyCredentials(BaseUser user, String password);
    public boolean logout(BaseUser user, HttpServletRequest request);
    public boolean isLoggedin(BaseUser user, HttpServletRequest request);
}
