package con.frontmarket.cart;

import con.frontmarket.Command;
import con.frontmarket.production.Food;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class CartListController implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    if (Objects.isNull(req.getSession().getAttribute("id"))) {
      return "redirect:/loginForm.jsp";
    }

    String paramFood = req.getParameter("food");
    if (paramFood.equals("")) {
      return "redirect:/cartView.jsp";
    }

    String method = req.getMethod();

    if (method.equals("POST")) {
      doPost(req, resp);
    }

    return "/cartView.jsp";
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    ServletContext servletContext = req.getServletContext();
    List<Food> foodList = (List<Food>) servletContext.getAttribute("foodList");
    Cart cart = (Cart) req.getSession().getAttribute("cart");
    String paramFood = req.getParameter("food");

    int paramQuantity = Integer.parseInt(req.getParameter("quantity"));

    ArrayList<Cart.Item> cartItems = cart.getItems();

    for (Food food : foodList) {
      if (food.getName().equals(paramFood)) {
        if (food.getQuantity() < paramQuantity) {
          resp.sendRedirect("/amountException.jsp");
          return;
        }
        cartItems.add(new Cart.Item(food.getName(), food.getPrice(), paramQuantity));
        int remainingQty = food.getQuantity() - paramQuantity;
        food.setQuantity(remainingQty);
      }
    }
  }

}
