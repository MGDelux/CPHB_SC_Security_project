package Controllers;

import Controllers.widget.Navbar;
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
    protected static final UserRegister REGISTER_SERVICE;
    protected static final UserLogin LOGIN_SERVICE;
    protected static final UserPresistence USER_SERVICE;
    protected static final ProductPerstistence PRODUCT_SERVICE;
    protected static final CommentPersistence COMMENT_SERVICE;

    static {
        COMMENT_SERVICE = getCommentService();
        PRODUCT_SERVICE = getProductService();
        USER_SERVICE = getUserService();
        LOGIN_SERVICE = getLoginService();
        REGISTER_SERVICE = getRegisterService(); }

    private static CommentPersistence getCommentService() {
        CommentService commentService = new CommentService();
        return new CommentPersistence(commentService);
    }

    public static ProductPerstistence getProductService() {
        ProductService productService = new ProductService();
        return new ProductPerstistence(productService);
    }

    public static UserPresistence getUserService() {
        UserService userService = new UserService();
        return new UserPresistence(userService);
    }

    public static UserLogin getLoginService() {
        LoginService loginService = new LoginService();
        return new UserLogin(loginService);
    }

    public static UserRegister getRegisterService() {
        RegisterService registerService = new RegisterService();
        return new UserRegister(registerService);
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
        req.setAttribute("indexNavbar", new Navbar(req));
        req.setAttribute("navbar", new Navbar(req));
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
