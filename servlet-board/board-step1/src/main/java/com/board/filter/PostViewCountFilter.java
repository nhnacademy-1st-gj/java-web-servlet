package com.board.filter;

import com.board.domain.PostRepository;
import com.board.entity.Post;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "postViewCountFilter", urlPatterns = "/eachPost.do")
public class PostViewCountFilter implements Filter {
  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");
    long postId = Long.parseLong(req.getParameter("postId"));
    Post post = postRepository.getPost(postId);

    post.increaseViewCount();
    chain.doFilter(req, resp);
  }
}

