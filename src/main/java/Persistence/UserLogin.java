package Persistence;

import Models.Users.BaseUser;
import Service.Interfaces.ILoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:08
 **/
public class UserLogin {
    private final ILoginService userLogin;

    public UserLogin(ILoginService ILoginService) {
        this.userLogin = ILoginService;
    }

    public boolean verifyCredentials(BaseUser user, String password){
       return this.userLogin.verifyCredentials(user, password);
    }
    public boolean logout(BaseUser user, HttpServletRequest request){
    return this.logout(user, request);
    }
    public boolean isLoggedin(BaseUser user, HttpServletRequest request){
        return this.isLoggedin(user, request);
    }


}
