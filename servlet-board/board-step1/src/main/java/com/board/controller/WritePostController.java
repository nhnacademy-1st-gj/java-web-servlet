package com.board.controller;

import com.board.domain.PostRepository;
import com.board.entity.ConcretePost;
import com.board.entity.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class WritePostController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Post post = new ConcretePost();
    post.setTitle(req.getParameter("title"));
    post.setContent(req.getParameter("content"));
    post.setWriterUserId(req.getParameter("userId"));

    PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

    LocalDateTime currentDateTime = LocalDateTime.now();
    post.setWriteTime(currentDateTime);

    long postId = postRepository.register(post);
    post.setId(postId);

    return "redirect:/postList.jsp";
  }
}
