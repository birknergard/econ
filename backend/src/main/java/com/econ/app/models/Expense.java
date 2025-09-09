package com.econ.app.models;

import java.util.Objects;

public class Expense extends Field {

  private double cost;
  private String category;

  public Expense(String id, String name, double cost, String category) {
    super(id, name);
    this.cost = cost;
    this.category = category;
  }

  public double getCost() {
    return this.cost;
  }

  public String getCategory() {
    return this.category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Expense)) return false;
    Expense expense = (Expense) o;
    return (expense.getId().equals(this.id)
        && expense.getName().equals(this.name)
        && expense.getCost() == this.cost
        && expense.getCategory().equals(this.category));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.cost, this.category);
  }
}
