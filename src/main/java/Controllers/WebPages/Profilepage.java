package Controllers.WebPages;

import Controllers.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY Emil @ 17-11-2021 - 15:36
 **/
@WebServlet({"/profile", "/profile/*"})
public class Profilepage extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);

        render("profilepage", "/profilepage.jsp", req, resp);
    }
}


