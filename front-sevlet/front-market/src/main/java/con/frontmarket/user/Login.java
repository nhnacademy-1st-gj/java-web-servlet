package con.frontmarket.user;

import con.frontmarket.Command;
import con.frontmarket.cart.Cart;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class Login implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String method = req.getMethod();

    if (method.equals("GET")) {
      return doGet(req, resp);
    } else if (method.equals("POST")) {
      return doPost(req, resp);
    }

    return "foodListView.jsp";
  }

  protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession();
    Object id = session.getAttribute("id");

    if (Objects.isNull(id)) {
      return "redirect:/loginForm.jsp";
    } else {
      return "redirect:/foodListView.jsp";
    }
  }

  protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


    User user = (User) req.getServletContext().getAttribute("user");


    String requestId = user.getId();
    String requestPassword = user.getPassword();

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    if (id.isBlank() || password.isBlank()) {
      return "redirect:/loginForm.jsp";
    }

    if (requestId.equals(id) && requestPassword.equals(password)) {
      HttpSession session = req.getSession();
      session.setAttribute("id", id);
      session.setAttribute("cart", new Cart());
      user.setBalance(20_000);
      return "redirect:/foodListView.jsp";
    } else {
      return "redirect:/loginForm.jsp";
    }

  }


}
