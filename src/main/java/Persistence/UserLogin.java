package Persistence;

import Models.Users.BaseUser;
import Service.Interfaces.ILoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 18-11-2021 - 20:08
 **/
public class UserLogin {
    private final ILoginService userLogin;

    public UserLogin(ILoginService ILoginService) {
        this.userLogin = ILoginService;
    }

    public boolean verifyCredentials(BaseUser user, String password) {
        return this.userLogin.verifyCredentials(user, password);
    }

    public boolean logout(BaseUser user, HttpServletRequest request) {
        return this.logout(user, request);
    }

    public void SetLoggedin(BaseUser user, boolean status) throws Exception {
        this.userLogin.SetLoggedin(user,status);
    }

    public boolean isLoggedIn(BaseUser user, HttpServletRequest request) {

        return this.userLogin.isLoggedIn(user, request);

    }

    public boolean DoReAuthUser(BaseUser user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return this.userLogin.reAuthUser(user, request,response);

    }

}