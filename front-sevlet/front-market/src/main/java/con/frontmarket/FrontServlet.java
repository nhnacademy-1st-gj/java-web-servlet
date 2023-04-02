package con.frontmarket;

import con.frontmarket.cart.CartListController;
import con.frontmarket.cart.Pay;
import con.frontmarket.production.FoodListController;
import con.frontmarket.user.Login;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
  private static final String REDIRECT_PREFIX = "redirect:";

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Command command = resolveServlet(req.getServletPath());
      String view = command.execute(req, resp);

      if (view.startsWith(REDIRECT_PREFIX)) {
        resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
      } else {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
      }

    } catch (Exception e) {
      log.error("", e);

    }
  }

  private Command resolveServlet(String servletPath) {
    Command command = null;

    if ("/foodStand.do".equals(servletPath)) {
      command = new FoodListController();
    } else if ("/login.do".equals(servletPath)) {
      command = new Login();
    } else if ("/cart.do".equals(servletPath)) {
      command = new CartListController();
    } else if ("/pay.do".equals(servletPath)) {
      command = new Pay();
    } else if ("/language.do".equals(servletPath)) {
      command = new LanguageController();
    }
    return command;
  }
}
