package com.board.domain;

import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapUserRepository implements UserRepository {

  ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

  @Override
  public void add(User user) {
    userMap.put(user.getId(), user);
  }

  @Override
  public void modify(User user) {
    userMap.put(user.getId(), user);
  }

  @Override
  public User remove(String id) {
    return userMap.remove(id);
  }

  @Override
  public User getUser(String id) {
    return userMap.get(id);
  }

  @Override
  public List<User> getUsers() {
    return new ArrayList<>(userMap.values());
  }
}
