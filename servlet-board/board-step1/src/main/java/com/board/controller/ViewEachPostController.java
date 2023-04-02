package com.board.controller;

import com.board.domain.PostRepository;
import com.board.entity.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class ViewEachPostController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    long postId = Long.parseLong(req.getParameter("postId"));
    PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");
    Post post = postRepository.getPost(postId);

    req.setAttribute("post", post);

    return "/eachPost.jsp";
  }
}
