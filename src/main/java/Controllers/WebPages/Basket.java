package Controllers.WebPages;

import Config.Sanitize;
import Controllers.BaseServlet;
import Models.Store.CustomerBasket;
import Models.Store.Order;
import Models.Users.Address;
import Models.Users.BaseUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathias @ 25-11-2021 - 13:15
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends BaseServlet {
    @Override
    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.setUp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUp(req, resp);
        getBasketService().calculateTotalPrice(req);

        render("basket page", "/checkout.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("deleteItem") != null) {
                BaseUser user = (BaseUser) req.getSession().getAttribute("user");
                getBasketService().removeProductFromBasket(Integer.parseInt(req.getParameter("basketId")), user, req);
                doGet(req, resp);
            }
            try {
                String fistname = Sanitize.santizeHTML(req.getParameter("GFirstName"));
                String lastname = Sanitize.santizeHTML(req.getParameter("GLastName"));
                String username = Sanitize.santizeHTML(req.getParameter("GUsername"));
                String shippingAdress = Sanitize.santizeHTML(req.getParameter("Gaddress"));
                String houseNumber = Sanitize.santizeHTML(req.getParameter("Gaddress2"));
                int zipCode = Integer.parseInt(req.getParameter("Gzip"));
                String country = Sanitize.santizeHTML(req.getParameter("Gcountry"));
                if (req.getParameter("checkOut") != null) {
                    BaseUser user = (BaseUser) req.getSession().getAttribute("user");
                    if (req.getParameter("saveShippingInfo") != null) {
                        try {
                            user.getCustomerInfomation().setFirstName(fistname);
                            user.getCustomerInfomation().setLastName(lastname);
                            user.setUsername(username);
                            Address address = new Address(shippingAdress, houseNumber, zipCode, "todo", country);
                            user.getCustomerInfomation().setAddress(address);
                            CustomerBasket customerBasket = (CustomerBasket) req.getSession().getAttribute("userBasket");
                            Order order = new Order(customerBasket);

                            getUserService().InternalModifyUser(user);
                            getOrderService().createOrder(user, order);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        Address address = new Address(shippingAdress, houseNumber, zipCode, "todo", country);
                        user.getCustomerInfomation().setAddress(address);
                        CustomerBasket customerBasket = (CustomerBasket) req.getSession().getAttribute("userBasket");
                        Order order = new Order(customerBasket);
                        getOrderService().createOrder(user, order);
                        System.out.println("order created with updated without information");

                    }
                }
                resp.sendRedirect(req.getContextPath() + "/thankyou");
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (NullPointerException e) {
            System.out.println(e);
        }

    }
}
