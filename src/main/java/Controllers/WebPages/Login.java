package Controllers.WebPages;

import Config.Sanitize;
import Config.VerifyRecaptcha;
import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * CREATED BY mathias @ 16-11-2021 - 12:42
 **/
@WebServlet({"/login", "/login/*"})
public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
        render("login page", "/login.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean allowLogin;

        int login_attempts;
        if (req.getSession().getAttribute("loginCount") == null) {
            req.getSession().setAttribute("loginCount", 0);
            login_attempts = 0;
        } else {
            login_attempts = (int) req.getSession().getAttribute("loginCount");
        }
        String email = Sanitize.santizeHTML(req.getParameter("email"));
        String password = Sanitize.santizeHTML(req.getParameter("password"));
        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        login_attempts++;
        req.getSession().setAttribute("loginCount", login_attempts);
        allowLogin = login_attempts <= 4;
        try {
            BaseUser user = getUserService().getUser(email);
            if (getLoginService().verifyCredentials(user, password) && VerifyRecaptcha.verify(gRecaptchaResponse) && allowLogin) {
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
        } catch (Exception loginError) { //TODO: FIX

            req.setAttribute("LogInError", "Email or password incorrect ");
            if (!allowLogin) {
                req.setAttribute("LogInError", "Login not allowed, too many failed attempts");
            }
            doGet(req, resp);

        }


    }
}
