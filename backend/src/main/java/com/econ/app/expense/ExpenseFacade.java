package com.econ.app.expense;

import com.econ.app.models.*;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseFacade {
  private ExpenseRepo repository;

  @Autowired
  public ExpenseFacade(ExpenseRepo expenseRepo) throws SQLException {
    this.repository = expenseRepo;
  }

  public boolean exists(String id) throws Exception {
    return repository.exists(id);
  }

  public Expense[] getAll() throws Exception {
    return repository.getAll();
  }

  public ExpenseByCategory getExpenseByCategories() throws Exception {
    Expense[] unsorted = repository.getAll();
    return new ExpenseByCategory(unsorted);
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
