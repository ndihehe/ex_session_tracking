package org.example;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

import DB.*;
import javax.servlet.ServletException;
@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String productCode = request.getParameter("productCode");

        HttpSession session = request.getSession();

        YourCart cart =
                (YourCart) session.getAttribute("cart");

        if (cart != null) {
            cart.removeLineItem(productCode);
        }

        session.setAttribute("cart", cart);

        request.getRequestDispatcher("/Cate.jsp")
                .forward(request, response);
    }
}