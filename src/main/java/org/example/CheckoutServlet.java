package org.example;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import DB.*;

    @WebServlet("/checkout")
    public class CheckoutServlet extends  HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session =  request.getSession();

            YourCart cart = (YourCart) session.getAttribute("cart");

            if (cart == null || cart.getItems().isEmpty()) {

                request.setAttribute("message", "ur cart is empty!");
                request.getRequestDispatcher("/src/main/webapp/Cate.jsp").forward(request, response);
                return;
            }

            request.setAttribute("cart", cart);
            request.getRequestDispatcher("/src/main/webapp/checkout.jsp").forward(request, response);
    }
}
