package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Users.BaseUser;
import Models.Users.Permissions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 16-11-2021 - 12:42
 **/
@WebServlet({"/admin", "/admin/*"})
public class Admin extends BaseServlet {
    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseUser user = (BaseUser) req.getSession().getAttribute("user");
        if (user.checkForPermission(Permissions.UserPermissions.VIEW_ADMIN_PAGE)) {
            setUp(req, resp);
            render("admin page", "/admin.jsp", req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/");

        }


    }
}

