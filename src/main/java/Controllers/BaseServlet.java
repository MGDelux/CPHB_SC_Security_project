package Controllers;

import Models.Store.Log;
import Models.Users.BaseUser;
import Persistence.*;
import Service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/*
This servlet is a general servlet. You should create a servles for each type of requests you have.
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    //now this is real programming lmao
    protected static final UserRegister REGISTER_SERVICE;
    protected static final UserLogin LOGIN_SERVICE;
    protected static final UserPresistence USER_SERVICE;
    protected static final ProductPerstistence PRODUCT_SERVICE;
    protected static final CommentPersistence COMMENT_SERVICE;
    protected static final BasketPersistence BASKET_SERVICE;
    protected static final OrderPersistence ORDER_SERVICE;

    static {
        ORDER_SERVICE = getOrderService();
        BASKET_SERVICE = getBasketService();
        COMMENT_SERVICE = getCommentService();
        PRODUCT_SERVICE = getProductService();
        USER_SERVICE = getUserService();
        LOGIN_SERVICE = getLoginService();
        REGISTER_SERVICE = getRegisterService();
    }

    protected static OrderPersistence getOrderService() {
        return new OrderPersistence(new OrderService());
    }

    protected static BasketPersistence getBasketService() {
        return new BasketPersistence(new BasketService());
    }

    protected static CommentPersistence getCommentService() {

        return new CommentPersistence(new CommentService());
    }

    protected static ProductPerstistence getProductService() {

        return new ProductPerstistence(new ProductService());
    }

    protected static UserPresistence getUserService() {
        return new UserPresistence(new UserService());
    }

    protected static UserLogin getLoginService() {
        return new UserLogin(new LoginService());
    }

    protected static UserRegister getRegisterService() {

        return new UserRegister(new RegisterService());
    }


    protected static BaseUser getUser(HttpServletRequest request, HttpServletResponse response, String errorMsgIfNull) throws IOException {
        HttpSession session = request.getSession();
        BaseUser user = (BaseUser) session.getAttribute("user");
        if (user == null) {
            session.setAttribute("loggedInStatus", errorMsgIfNull);
            response.sendRedirect(request.getContextPath() + "/login/");
        }
        return user;
    }

    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    protected void render(String title, String content, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher(content).forward(req, resp);
        Log log = new Log(Log.WarnLevel.LOW_RISK, req, "Render");
        log(log);

    }

    protected void log(Log log) {
        System.err.print(log.toString());
    }
}
