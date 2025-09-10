package com.econ.app.expense;

import com.econ.app.models.*;
import java.sql.SQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
    origins = "http://localhost:8081",
    methods = {
      RequestMethod.GET,
      RequestMethod.POST,
      RequestMethod.PUT,
      RequestMethod.DELETE,
    })
@RequestMapping("/expenses")
public class ExpenseController {
  private ExpenseFacade facade;

  public ExpenseController() throws SQLException {
    this.facade = new ExpenseFacade();
  }

  @GetMapping("/ex")
  @ResponseBody
  public ResponseEntity<Expense[]> getExpenses() throws Exception {
    return ResponseEntity.ok(this.facade.getAll());
  }

  // TODO: Implement
  @GetMapping("/ex/category")
  @ResponseBody
  public ResponseEntity<ExpenseList> getExpensesByCategory() throws Exception {
    return ResponseEntity.ok(this.facade.getExpenseByCategories());
  }

  @GetMapping("/ex={expenseId}")
  @ResponseBody
  public ResponseEntity<Expense> getExpense(@RequestParam(name = "expenseId") String id)
      throws Exception {
    return ResponseEntity.ok(this.facade.get(id));
  }

  @PostMapping("/ex")
  public void postExpense(@RequestBody Expense newExpense) throws Exception {
    if (!this.facade.exists(newExpense.getId())) {
      this.facade.create(newExpense);
    }
  }

  @PutMapping("/ex")
  public void putExpense(@RequestBody Expense editedExpense) throws Exception {
    if (this.facade.exists(editedExpense.getId())) {
      this.facade.edit(editedExpense);
    }
  }

  @DeleteMapping("/ex={expenseId}")
  public void removeExpense(@RequestParam(name = "expenseId") String id) throws Exception {
    if (this.facade.exists(id)) {
      this.facade.remove(id);
    }
  }
}
