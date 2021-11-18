package Controllers.WebPages;

import Config.VerifyRecaptcha;
import Controllers.BaseServlet;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 16-11-2021 - 12:42
 **/
@WebServlet({"/login", "/login/*"})
public class Login extends BaseServlet {
    private static EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req,resp);

        render("login page","/login.jsp",req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
            VerifyRecaptcha.verify(gRecaptchaResponse);
         //   req.getSession().setAttribute("user",user);
         //   req.getSession().setAttribute("role", user.getUserPermissions());
            req.getSession().setAttribute("loggedIn",true);
            resp.sendRedirect(req.getContextPath()+"");

            return;
        } catch (Exception loginError) {
            req.setAttribute("error", loginError.getMessage());
            System.out.println("error "+ loginError.getMessage());
            doGet(req,resp);
            return;
        }
    }
}
