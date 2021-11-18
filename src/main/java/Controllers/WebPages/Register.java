package Controllers.WebPages;

import Config.ErrorHandling.UserInternalError;
import Config.VerifyRecaptcha;
import Controllers.BaseServlet;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUp(req,resp);
        render("Register", "/register.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        try {
            if (VerifyRecaptcha.verify(gRecaptchaResponse) && getRegisterService().checkIfUserInSystem(email, password)) {
                getRegisterService().register(email, password);
                request.setAttribute("SuccessFullReq","You have been successfully registered");
                response.sendRedirect(request.getContextPath()+"/login");

            }else {
                if (!VerifyRecaptcha.verify(gRecaptchaResponse)){
                    request.setAttribute("ReqError","Recaptcha Error please do the reCAPTCHA again.");

                }else {
                    request.setAttribute("ReqError", "Email is already registered to a user");
                }
                request.removeAttribute("email");
                request.removeAttribute("password");
                request.removeAttribute("g-recaptcha-response");
                doGet(request,response);

            }

        } catch (UserInternalError userInternalError) {
            userInternalError.printStackTrace();
        } catch (Exception e) { //TODO GUESS WHAT YEA CUSTOM EXCEPTION
            e.printStackTrace();
        }
    }
}

