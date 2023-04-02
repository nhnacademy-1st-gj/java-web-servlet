package com.board.controller;

import com.board.domain.UserRepository;
import com.board.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyUserController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");
    User user = userRepository.getUser(req.getParameter("userId"));
    user.setName(req.getParameter("userName"));
    userRepository.modify(user);

    return "/adminPage.jsp";
  }
}
