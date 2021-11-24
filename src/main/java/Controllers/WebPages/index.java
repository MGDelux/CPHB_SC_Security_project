package Controllers.WebPages;

import Controllers.BaseServlet;
import Models.Store.Log;
import Models.Store.Product;
import Models.Store.ProductComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        if (req.getParameter("AddCupcakeToKurv") != null) {
        Product productToBasket = getProductService().getSpecificProduct(Long.parseLong(req.getParameter("productId")));
            System.out.println(productToBasket);

        } else if (req.getParameter("PostComment") != null) {
            System.out.println("post comment");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        setUp(req, resp);
        try {
            if (getProductService().getAllProducts() == null || getProductService().getAllProducts().isEmpty()) {
                //throw new exception yada
                req.setAttribute("productsInStore", false);
            } else {
                productList.addAll(getProductService().getAllProducts());
                req.setAttribute("productsInStore", true);

                req.setAttribute("products", productList);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        render("index", "/WEB-INF/pages/index.jsp", req, resp);

    }
}
