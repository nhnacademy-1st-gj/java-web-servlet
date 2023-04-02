package com.market.cart;


import java.util.ArrayList;

public class Cart {
  private final ArrayList<Item> items = new ArrayList<>();

  public ArrayList<Item> getItems() {
    return items;
  }

  public static class Item {
    private final String name;
    private final int price;
    private final int quantity;

    public Item(String name, int amount, int quantity) {
      this.name = name;
      this.price = amount;
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

  }
}
