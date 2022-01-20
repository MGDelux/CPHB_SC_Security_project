package Controllers.WebPages;

import Config.Sanitize;
import Config.VerifyRecaptcha;
import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * CREATED BY Emil @ 19-01-2022 - 12:34
 **/
public class twoFA extends BaseServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        boolean allowLogin;

        int login_attempts;
        if (req.getSession().getAttribute("loginCount") == null) {
            req.getSession().setAttribute("loginCount", 0);
            login_attempts = 0;
        } else {
            login_attempts = (int) req.getSession().getAttribute("loginCount");
        }
        String key = Sanitize.santizeHTML(req.getParameter("SecretKey"));
        login_attempts++;
        req.getSession().setAttribute("loginCount", login_attempts);
        allowLogin = login_attempts <= 4;
        try {
            BaseUser user = (BaseUser) req.getSession().getAttribute("email");;
            if (Objects.equals(getLoginService().getTOTPCode(user.getSecretKey()), key) && allowLogin) {
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("loggedIn", true);
                req.getSession().setAttribute("loginTime", System.currentTimeMillis());
                getLoginService().SetLoggedin(user, true);
                req.getSession().setAttribute("doReAuth", false);
                req.changeSessionId();
                resp.sendRedirect(req.getContextPath() + "/");
            } else {
                req.setAttribute("LogInError", "Email or password incorrect ");
                if (!allowLogin) {
                    req.setAttribute("LogInError", "Login not allowed, too many failed attempts");
                }
                doGet(req, resp);

            }
        } catch (Exception loginError) {

            req.setAttribute("LogInError", "Email or password incorrect ");
            if (!allowLogin) {
                req.setAttribute("LogInError", "Login not allowed, too many failed attempts");
            }
            doGet(req, resp);

        }


    }
    }


