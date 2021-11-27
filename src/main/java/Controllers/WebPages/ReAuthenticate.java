package Controllers.WebPages;

import Config.VerifyRecaptcha;
import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 27-11-2021 - 15:58
 **/
@WebServlet({"/authenticate", "/authenticate/*"})

public class ReAuthenticate extends BaseServlet {

    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        super.setUp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUp(req, resp);
        render("reauth page", "/ReAuth.jsp", req, resp);

        try {
            req.getSession().setAttribute("loggedIn", false);
            BaseUser user = (BaseUser) req.getSession().getAttribute("user");
            getLoginService().SetLoggedin(user, false);
            req.getSession().setAttribute("user", null);
            req.setAttribute("ReAuthenticated", false);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        try {
            BaseUser user = getUserService().getUser(email);
            if (getLoginService().verifyCredentials(user, password) && VerifyRecaptcha.verify(gRecaptchaResponse)) {
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("loggedIn", true);
                getLoginService().SetLoggedin(user, true);
                req.changeSessionId();
                req.getSession().setAttribute("loginTime",System.currentTimeMillis());
                req.setAttribute("ReAuthenticated", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
