package Controllers.WebPages;

import Config.ErrorHandling.UserInternalError;
import Controllers.BaseServlet;
import Service.Interfaces.IRegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:07
 **/
@WebServlet({"/register", "/register/*"})
public class Register extends BaseServlet {


    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);

        render("Register", "/register.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email1");
        String password = request.getParameter("password1");
        try {
            getRegisterService().register(email, password);
        } catch (UserInternalError userInternalError) {
            userInternalError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

