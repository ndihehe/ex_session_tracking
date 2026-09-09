package org.example;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import DB.*;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String productCode = request.getParameter("productCode");
        String quantityText = request.getParameter("quantity");

        int quantity = Integer.parseInt(quantityText);

        HttpSession session = request.getSession();

        YourCart cart = (YourCart) session.getAttribute("cart");

        if (cart != null) {
            cart.updateQuantity(productCode, quantity);
        }

        session.setAttribute("cart", cart);

        request.getRequestDispatcher("/src/main/webapp/Cate.jsp")
                .forward(request, response);
    }
}
