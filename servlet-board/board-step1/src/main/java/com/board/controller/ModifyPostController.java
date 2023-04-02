package com.board.controller;

import com.board.domain.PostRepository;
import com.board.entity.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyPostController implements Command{
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PostRepository postRepository = (PostRepository)req.getServletContext().getAttribute("postRepository");
    Post post = postRepository.getPost(Long.parseLong(req.getParameter("postId")));



    return "/postList.jsp";
  }
}
