package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 24-11-2021 - 13:41
 **/
@WebServlet({"/checkout", "/checkout/*"})
public class CheckOut  extends BaseServlet {

    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      setUp(req,resp);
        System.out.println("get checkout");
        System.out.println(req.getSession().getAttribute("user"));


        BaseUser user = (BaseUser) req.getSession().getAttribute("user");
        if (getLoginService().isLoggedIn(user,req)){
                render("login page", "/login.jsp", req, resp);

        }else {
            render("login page", "/register.jsp", req, resp);

        }
    }
}
