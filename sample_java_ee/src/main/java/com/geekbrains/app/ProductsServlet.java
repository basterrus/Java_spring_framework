package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

// response http://localhost:8080/sample_java_ee_war/product?a=1&b=Banana&c=1000

@WebServlet(name="ProductsServlet", urlPatterns = "/product")
public class ProductsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");

        String firstParam = req.getParameter("a");
        String secondParam = req.getParameter("b");
        String thirdParam = req.getParameter("c");

        Map<Integer, Product> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new Product(firstParam, secondParam, thirdParam));
        }
        for (int i = 0; i <map.size(); i++) {
            resp.getWriter().printf("<h1>" + map.get(i).toString() +"<h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
