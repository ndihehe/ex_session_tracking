package org.example;

import DB.Product;
import DB.ProductData;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/home"})
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {


        List<Product> products = ProductData.getProducts();


        request.setAttribute("products", products);


        request.getRequestDispatcher("/Shop.jsp")
                .forward(request, response);
    }
}