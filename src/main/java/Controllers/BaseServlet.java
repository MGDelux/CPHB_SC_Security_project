package Controllers;

import Controllers.widget.Navbar;
import Models.Store.Log;
import Models.Users.BaseUser;
import Service.ILoginService;
import Service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;


/*
This servlet is a general servlet. You should create a servles for each type of requests you have.
 */
@WebServlet(name = "SomeController")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();

        // example login

    }

    protected static BaseUser getUser(HttpServletRequest request, HttpServletResponse response, String errorMsgIfNull) throws IOException {
        HttpSession session = request.getSession();
        BaseUser user = (BaseUser) session.getAttribute("user");
        if (user == null) {
            session.setAttribute("loggedIn", errorMsgIfNull);
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
      //  req.setAttribute("navbar", new Navbar(req));
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher(content).forward(req, resp);
       Log log = new Log(Log.WarnLevel.LOW_RISK,req,"Render");
       log(log);

    }

    protected void log(Log log) {
        System.err.print(log.toString());
    }
}
