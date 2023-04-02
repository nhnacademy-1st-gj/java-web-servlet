package com.market.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(false);
    if (Objects.isNull(session)) {
      session.invalidate();
    }
    resp.sendRedirect("login.html");
  }
}
