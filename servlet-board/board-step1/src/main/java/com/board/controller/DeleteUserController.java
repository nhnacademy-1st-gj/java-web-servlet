package com.board.controller;

import com.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");
    userRepository.remove(req.getParameter("userId"));
    return "/adminPage.jsp";
  }
}
