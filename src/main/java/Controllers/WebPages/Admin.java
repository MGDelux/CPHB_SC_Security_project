package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Store.Log;
import Models.Users.Permissions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * CREATED BY mathias @ 16-11-2021 - 12:42
 **/
@WebServlet({"/admin", "/admin/*"})
public class Admin extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (getUser(req,resp,"Please log in admin.")!=null){
        if (getUser(req,resp,"you do not have the correct permissions").checkForPermission(Permissions.UserPermissions.VIEW_ADMIN_PAGE)){
            setUp(req, resp);
            render("admin page","/admin.jsp",req,resp);
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("adminErrorMSG", "You do not have the valid permissions");
            Log toLog = new Log(Log.WarnLevel.MED_RISK,req,"Attempted to access admin page without correct permissions");
            log(toLog);
        }
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("adminErrorMSG", "Log in to view this page");
            Log toLog = new Log(Log.WarnLevel.HIGH_RISK,req,"Attempted to access admin page without being logged in");
            log(toLog);

        }


    }
}
