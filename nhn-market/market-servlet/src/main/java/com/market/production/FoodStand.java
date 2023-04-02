package com.market.production;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FoodStand extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    List<Food> foodList = (List<Food>) getServletContext().getAttribute("foodList");
    resp.getWriter().println("<a href='cart'>To Cart</a>");

    for (Food food : foodList) {
      resp.getWriter().println("<form action=\"cart\" method=\"POST\">");
      resp.getWriter().println("Name: " + food.getName() + " | Won: " + food.getPrice() + " | Remaining: " + food.getQuantity() +
              "   <input type=\"number\" name=\"quantity\">");
      resp.getWriter().println("<input type=\"hidden\" name=\"food\" value=\"" + food.getName() + "\">");
      resp.getWriter().println("<input type=\"submit\" value=\"submit\">");
      resp.getWriter().println("</form><br/>");
    }


  }
}
