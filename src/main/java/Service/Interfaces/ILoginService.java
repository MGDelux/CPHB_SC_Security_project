package Service.Interfaces;

import Models.Users.BaseUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ILoginService {
    boolean verifyCredentials(BaseUser user, String password);

    boolean logout(BaseUser user, HttpServletRequest request);

    void SetLoggedin(BaseUser user, boolean status) throws Exception;

    boolean isLoggedIn(BaseUser user, HttpServletRequest request);

    boolean reAuthUser(BaseUser user, HttpServletRequest request, HttpServletResponse response) throws IOException;

    boolean ForceReAuth(BaseUser user, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
