package com.econ.app.income;

import com.econ.app.models.Field;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class Income extends Field {

  @NotNull private double amount;

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
    if (!(o instanceof Income)) return false;
    Income expense = (Income) o;
    return (expense.getId().equals(this.id)
        && expense.getName().equals(this.name)
        && expense.getAmount() == this.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.amount);
  }
}
