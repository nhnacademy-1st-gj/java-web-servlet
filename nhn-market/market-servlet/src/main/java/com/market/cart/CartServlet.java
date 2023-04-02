package com.market.cart;

import com.market.production.Food;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class CartServlet extends HttpServlet {
  Cart cart = new Cart();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    String paramFood = req.getParameter("food");
    int paramQuantity = Integer.parseInt(req.getParameter("quantity"));

    List<Food> foodList = (List<Food>) getServletContext().getAttribute("foodList");

    ArrayList<Cart.Item> items = cart.getItems();

    for (Food food : foodList) {
      if (food.getName().equals(paramFood)) {
        if (food.getQuantity() < paramQuantity) {
          resp.sendRedirect("/outOfStock.html");
          return;
        }
        items.add(new Cart.Item(food.getName(), food.getPrice(), paramQuantity));
        int remainingQty = food.getQuantity() - paramQuantity;
        food.setQuantity(remainingQty);
      }
    }
    resp.sendRedirect("/cart");

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    HttpSession session = req.getSession(false);
    if (Objects.isNull(session)) {
      resp.sendRedirect("/loginForm.html");
      return;
    }

    ArrayList<Cart.Item> items = cart.getItems();
    for (Cart.Item item : items) {
      resp.getWriter().println("Name: " + item.getName() + " | Won: " + item.getPrice() + " | Quantity: " + item.getQuantity() + "<br/>");
    }

    resp.getWriter().println("<a href='foodStand'>To Food List</a>");

  }
}
