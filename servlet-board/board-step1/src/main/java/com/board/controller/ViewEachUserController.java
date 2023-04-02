package com.board.controller;

import com.board.domain.UserRepository;
import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ViewEachUserController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    return doPost(req, resp);
  }

  public String doPost(HttpServletRequest req, HttpServletResponse resp) {
    String paramUserId = req.getParameter("userId");

    UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

    User user = userRepository.getUser(paramUserId);
    String id = user.getId();
    String name = user.getName();
    String profileFileName = user.getProfileFileName();

    log.info(user.toString());
    req.setAttribute("user", user);

    return "/eachUser.jsp";
  }
}
