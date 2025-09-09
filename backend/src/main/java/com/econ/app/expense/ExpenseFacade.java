package com.econ.app.expense;

import com.econ.app.models.Expense;
import java.sql.SQLException;

public class ExpenseFacade {
  private ExpenseRepo repository;

  public ExpenseFacade() throws SQLException {
    this.repository = new ExpenseRepo();
  }

  public boolean exists(String id) throws Exception {
    return repository.exists(id);
  }

  public Expense[] getAll() throws Exception {
    return repository.getAll();
  }

  public Expense get(String id) throws Exception {
    return repository.get(id);
  }

  public void create(Expense expense) throws Exception {
    repository.create(expense);
  }

  public void createMultiple(Expense[] expenses) throws Exception {
    repository.create(expenses);
  }

  public void edit(Expense expense) throws Exception {
    repository.edit(expense);
  }

  public void remove(String id) throws Exception {
    repository.remove(id);
  }
}
