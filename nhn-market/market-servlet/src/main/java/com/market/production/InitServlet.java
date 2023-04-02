package com.market.production;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InitServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    List<Food> foodList = new ArrayList<>();

    Iterator<String> stringIterator = getServletContext().getInitParameterNames().asIterator();
    while (stringIterator.hasNext()) {
      String next = stringIterator.next();
      String initParameter = getServletContext().getInitParameter(next);
      int[] split = Arrays.stream(initParameter.split(",")).mapToInt(str -> Integer.parseInt(str)).toArray();
      foodList.add(new Food(next, split[0], split[1]));
    }

    getServletContext().setAttribute("foodList", foodList);

    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().println("<a href='foodStand'>Product List</a>");


  }
}
