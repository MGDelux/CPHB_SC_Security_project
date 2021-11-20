package Controllers.WebPages;

import Config.VerifyRecaptcha;
import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.persistence.EntityManagerFactory;
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
    private static EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
   if (req.getAttribute("loggedIn").equals(true)){
       render("index", "/WEB-INF/pages/index.jsp", req, resp);
   }
        render("login page", "/login.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        try {
            BaseUser user = getUserService().getUser(email);
            if (getLoginService().verifyCredentials(user, password) && VerifyRecaptcha.verify(gRecaptchaResponse)) {
          req.getSession().setAttribute("user", user);
          req.getSession().setAttribute("loggedIn", true);
                System.err.print("USER LOGGED IN SUCESSFULLY");

                resp.sendRedirect(req.getContextPath() + "/");
            }else {
                doGet(req,resp);
            }

        } catch (Exception loginError) { //TODO: FIX
            req.setAttribute("error", loginError.getMessage());
            System.out.println("error " + loginError.getMessage());
            doGet(req, resp);
            return;
        }


    }
}
