package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 25-11-2021 - 13:15
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends BaseServlet {
    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUp(req, resp);
        render("basket page", "/basket.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("post");
            if (req.getParameter("deleteItem") != null) {
                System.out.println(req.getParameter("basketId"));
                BaseUser user = (BaseUser) req.getSession().getAttribute("user");
                getBasketService().removeProductFromBasket(Integer.parseInt(req.getParameter("basketId")), user, req);
                doGet(req, resp);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

    }
}
