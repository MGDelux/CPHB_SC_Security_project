package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Store.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 16-11-2021 - 12:36
 **/
@WebServlet("")
public class index extends BaseServlet {
    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ServletException, IOException {
       setUp(req, resp);
        render("index", "/WEB-INF/pages/index.jsp", req, resp);

    }
}
