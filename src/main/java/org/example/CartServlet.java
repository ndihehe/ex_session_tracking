package org.example;
import DB.Product;
import DB.ProductData;
import DB.YourCart;
import DB.LineItem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/cart")
public class CartServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");

        HttpSession session = request.getSession();
        YourCart cart = (YourCart) session.getAttribute("cart");

        if (cart == null) {
            cart = new YourCart();
        }

        Product product = ProductData.getProductByCode(productCode);

        if (product != null) {
            LineItem item = new LineItem(product, 1);

            cart.addLineItem(item);
        }

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("/Cate.jsp")
                .forward(request, response);
    }
}
