package con.frontmarket.user;

import lombok.Getter;

@Getter
public class User {
  private final String id;
  private final String password;
  private int balance;

  public User(String id, String password) {
    this.id = id;
    this.password = password;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
