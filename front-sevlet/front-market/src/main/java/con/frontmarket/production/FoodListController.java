package con.frontmarket.production;

import con.frontmarket.Command;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class FoodListController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) {

    ServletContext servletContext = req.getServletContext();
    List<Food> foodList = (List<Food>) servletContext.getAttribute("foodList");
    req.setAttribute("foodList", foodList);
    return "foodListView.jsp";
  }
}
