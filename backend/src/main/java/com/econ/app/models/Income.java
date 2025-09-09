package com.econ.app.models;

import java.util.Objects;

public class Income extends Field {
  private double amount;

  public Income(String id, String name, double amount) {
    super(id, name);
    this.amount = amount;
  }

  public double getAmount() {
    return this.amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Expense)) return false;
    Expense expense = (Expense) o;
    return (expense.getId().equals(this.id)
        && expense.getName().equals(this.name)
        && expense.getCost() == this.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.amount);
  }
}
