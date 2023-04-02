package con.frontmarket.cart;

import con.frontmarket.Command;
import con.frontmarket.user.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class Pay implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String method = req.getMethod();
    if (method.equals("POST")) {
      doPost(req, resp);
    }
    return "payView.jsp";
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    User user = (User) req.getServletContext().getAttribute("user");
    int userBalance = user.getBalance();
    int itemQty = Integer.parseInt(req.getParameter("itemQty"));
    String itemName = req.getParameter("itemName");

    Cart cart = (Cart) req.getSession().getAttribute("cart");
    ArrayList<Cart.Item> cartItems = cart.getItems();
    int cartBalance = 0;

    for (Cart.Item item : cartItems) {
      if (item.getName().equals(itemName)) {
        cartBalance = item.getPrice() * itemQty;
        if (userBalance < cartBalance) {
          resp.sendRedirect("/notEnoughMoneyException.jsp");
          return;
        }
      }
    }
    req.getSession().setAttribute("cartBalance", cartBalance);

    int remainingBalance = userBalance - cartBalance;
    req.getSession().setAttribute("remainingBalance", remainingBalance);

  }
}
