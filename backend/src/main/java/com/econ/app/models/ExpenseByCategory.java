package com.econ.app.models;

import com.econ.app.enums.Categories;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;

public class ExpenseByCategory {
  @NotNull private Expense[] housing;

  @NotNull private Expense[] food;

  @NotNull private Expense[] transport;

  @NotNull private Expense[] other;

  @NotNull private Expense[] savings;

  @NotNull private Expense[] debt;

  private Expense[] filterByCategory(Expense[] unsortedList, String category) {
    Expense[] sortedList =
        Arrays.stream(unsortedList)
            .filter(expense -> expense.getCategory().toUpperCase().equals(category))
            .toArray(Expense[]::new);
    return sortedList;
  }

  public ExpenseByCategory() {
    this.housing = new Expense[0];
    this.food = new Expense[0];
    this.transport = new Expense[0];
    this.other = new Expense[0];
    this.savings = new Expense[0];
    this.debt = new Expense[0];
    this.housing = new Expense[0];
  }

  public ExpenseByCategory(Expense[] expenses) {
    this.housing = filterByCategory(expenses, Categories.HOUSING.name());
    this.food = filterByCategory(expenses, Categories.FOOD.name());
    this.transport = filterByCategory(expenses, Categories.TRANSPORT.name());
    this.other = filterByCategory(expenses, Categories.OTHER.name());
    this.savings = filterByCategory(expenses, Categories.SAVINGS.name());
    this.debt = filterByCategory(expenses, Categories.DEBT.name());
  }

  public Expense[] getHousing() {
    return housing;
  }

  public Expense[] getFood() {
    return food;
  }

  public Expense[] getTransport() {
    return transport;
  }

  public Expense[] getOther() {
    return other;
  }

  public Expense[] getSavings() {
    return savings;
  }

  public Expense[] getDebt() {
    return debt;
  }
}
