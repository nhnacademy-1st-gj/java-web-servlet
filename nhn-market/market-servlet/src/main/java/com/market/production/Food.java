package com.market.production;

public class Food {
  private String name;
  private int price;
  private int quantity;

  public Food(String name, int price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Food{" +
            "name='" + name + '\'' +
            ", price=" + price +
            ", quantity= " + quantity +
            '}';
  }
}
