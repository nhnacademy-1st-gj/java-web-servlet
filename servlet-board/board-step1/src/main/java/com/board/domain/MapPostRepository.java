package com.board.domain;

import com.board.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MapPostRepository implements PostRepository {
  ConcurrentHashMap<Long, Post> postMap = new ConcurrentHashMap<>();
  long postId = 0;

  @Override
  public long register(Post post) {
    ++postId;
    postMap.put(postId, post);
    return postId;
  }

  @Override
  public void modify(Post post) {
    postMap.put(post.getId(), post);
  }

  @Override
  public Post remove(long id) {
    return postMap.remove(id);
  }

  @Override
  public Post getPost(long id) {
    return postMap.get(id);
  }

  @Override
  public List<Post> getPosts() {
    return new ArrayList<>(postMap.values());
  }
}
