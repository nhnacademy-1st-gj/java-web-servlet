package com.board.entity;

import java.time.LocalDateTime;

public class ConcretePost implements Post {
  private long id;
  private String title;
  private String content;
  private String userId;
  private LocalDateTime writeTime;
  private int viewCount;

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String getContent() {
    return content;
  }

  @Override
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String getWriterUserId() {
    return userId;
  }

  @Override
  public void setWriterUserId(String writerUserId) {
    this.userId = writerUserId;
  }

  @Override
  public LocalDateTime getWriteTime() {
    return writeTime;
  }

  @Override
  public void setWriteTime(LocalDateTime writeTime) {
    this.writeTime = writeTime;
  }

  @Override
  public int getViewCount() {
    return viewCount;
  }

  @Override
  public void increaseViewCount() {
    ++viewCount;
  }
}
