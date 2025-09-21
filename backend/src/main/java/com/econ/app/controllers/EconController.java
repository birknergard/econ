package com.econ.app.controllers;

import com.econ.app.expense.*;
import com.econ.app.income.*;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
    origins = {
      "http://localhost:8081",
      "http://127.0.0.1:8081",
      "http://10.0.2.2:8081",
      "exp://172.26.62.125:8081"
    },
    methods = {
      RequestMethod.GET,
      RequestMethod.POST,
      RequestMethod.PUT,
      RequestMethod.DELETE,
    })
@RequestMapping("/api/econ")
public class EconController {
  private ExpenseFacade expenseFacade;
  private IncomeFacade incomeFacade;

  @Autowired
  public EconController(ExpenseFacade exFacade, IncomeFacade inFacade) throws SQLException {
    this.expenseFacade = exFacade;
    this.incomeFacade = inFacade;
  }

  @GetMapping("/expense")
  @ResponseBody
  public ResponseEntity<Expense[]> getExpenses() throws Exception {
    return ResponseEntity.ok(this.expenseFacade.getAll());
  }

  @GetMapping("/expense={expenseId}")
  @ResponseBody
  public ResponseEntity<Expense> getExpense(@RequestParam(name = "expenseId") String id)
      throws Exception {
    return ResponseEntity.ok(this.expenseFacade.get(id));
  }

  @PostMapping("/expense")
  public void postExpense(@RequestBody Expense newExpense) throws Exception {
    if (!this.expenseFacade.exists(newExpense.getId())) {
      this.expenseFacade.create(newExpense);
    }
  }

  @PutMapping("/expense")
  public void putExpense(@RequestBody Expense editedExpense) throws Exception {
    if (this.expenseFacade.exists(editedExpense.getId())) {
      this.expenseFacade.edit(editedExpense);
    }
  }

  @DeleteMapping("/expense={expenseId}")
  public void removeExpense(@RequestParam(name = "expenseId") String id) throws Exception {
    if (this.expenseFacade.exists(id)) {
      this.expenseFacade.remove(id);
    }
  }

  @GetMapping("/income")
  @ResponseBody
  public ResponseEntity<Income[]> getIncomes() throws Exception {
    return ResponseEntity.ok(incomeFacade.getAll());
  }

  @GetMapping("/income={id}")
  @ResponseBody
  public ResponseEntity<Income> getIncome(@RequestParam(name = "incomeId") String id)
      throws Exception {
    return ResponseEntity.ok(incomeFacade.get(id));
  }

  @PostMapping("/income")
  public void postIncome(@RequestBody Income newIncome) throws Exception {
    if (!this.incomeFacade.exists(newIncome.getId())) {
      this.incomeFacade.create(newIncome);
    }
  }

  @PutMapping("/income")
  public void putIncome(@RequestBody Income editedIncome) throws Exception {
    if (this.incomeFacade.exists(editedIncome.getId())) {
      this.incomeFacade.edit(editedIncome);
    }
  }

  @DeleteMapping("/income={id}")
  public void removeIncome(@RequestParam(name = "incomeId") String id) throws Exception {
    if (this.incomeFacade.exists(id)) {
      this.incomeFacade.remove(id);
    }
  }
}
