package con.frontmarket;

import con.frontmarket.production.Food;
import con.frontmarket.user.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebListener
public class WebAppListner implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("user", new User("user1", "123"));

    List<Food> foodList = new ArrayList<>();
    foodList.add(new Food("onion", 1_000, 2));
    foodList.add(new Food("egg", 2_000, 5));
    foodList.add(new Food("spring onion", 500, 10));
    foodList.add(new Food("apple", 2_000, 20));

    servletContext.setAttribute("foodList", foodList);

  }
}
