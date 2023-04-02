package com.market.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(false);

    if (Objects.isNull(session)) {
      resp.sendRedirect("/loginForm.html");
    } else {
      resp.sendRedirect("/init");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String initId = getServletConfig().getInitParameter("id");
    String initPassword = getServletConfig().getInitParameter("password");

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    if (id.isBlank() || password.isBlank()) {
      resp.sendRedirect("/loginForm.html");
    }

    if (initId.equals(id) && initPassword.equals(password)) {
      HttpSession session = req.getSession();
      session.setAttribute("id", id);
      resp.sendRedirect("/login");
    } else {
      resp.sendRedirect("/loginForm.html");
    }

  }
}
