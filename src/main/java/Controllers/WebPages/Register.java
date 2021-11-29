package Controllers.WebPages;

import Config.ErrorHandling.UserInternalError;
import Config.PasswordStrengthValidation;
import Config.Sanitize;
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
        setUp(req, resp);
        render("Register", "/register.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = Sanitize.santizeHTML(request.getParameter("email"));
        String password = Sanitize.santizeHTML(request.getParameter("password"));
        String retypedPassword = Sanitize.santizeHTML(request.getParameter("RetypedPassword"));
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        try { //NESTED IF STATEMENTS FTW /S
            if (password.equals(retypedPassword) && PasswordStrengthValidation.ValidatePWStrength(password)) {
                if (VerifyRecaptcha.verify(gRecaptchaResponse) && getRegisterService().checkIfUserInSystem(email, password)) {
                    getRegisterService().register(email, password);
                    request.setAttribute("SuccessFullReq", "You have been successfully registered");
                    response.sendRedirect(request.getContextPath() + "/login");
                } else {
                    if (!VerifyRecaptcha.verify(gRecaptchaResponse)) {
                        request.setAttribute("ReqError", "Recaptcha Error please do the reCAPTCHA again.");

                    } else {
                        request.setAttribute("ReqError", "Email is already registered to a user");

                    }
                }
                request.removeAttribute("email");
                request.removeAttribute("password");
                request.removeAttribute("g-recaptcha-response");
            } else if (!PasswordStrengthValidation.ValidatePWStrength(password)) {
                request.setAttribute("ReqError", "Passwords is not strong enough");

            } else {
                request.setAttribute("ReqError", "Passwords does not match");
            }
            doGet(request, response);

        } catch (UserInternalError userInternalError) {
            userInternalError.printStackTrace();
        } catch (Exception e) { //TODO GUESS WHAT YEA CUSTOM EXCEPTION
            e.printStackTrace();
        }
    }
}

