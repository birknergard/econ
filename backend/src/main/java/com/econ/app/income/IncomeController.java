package com.econ.app.income;

import com.econ.app.models.Income;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
  private IncomeFacade facade;

  @Autowired
  public IncomeController(IncomeFacade facade) throws SQLException {
    this.facade = facade;
  }

  @GetMapping("/in")
  @ResponseBody
  public ResponseEntity<Income[]> getIncomes() throws Exception {
    return ResponseEntity.ok(facade.getAll());
  }

  @GetMapping("/in={incomeId}")
  @ResponseBody
  public ResponseEntity<Income> getIncome(@RequestParam(name = "incomeId") String id)
      throws Exception {
    return ResponseEntity.ok(facade.get(id));
  }

  @PostMapping("/in")
  public void postIncome(@RequestBody Income newIncome) throws Exception {
    if (!this.facade.exists(newIncome.getId())) {
      this.facade.create(newIncome);
    }
  }

  @PutMapping("/in")
  public void putIncome(@RequestBody Income editedIncome) throws Exception {
    if (this.facade.exists(editedIncome.getId())) {
      this.facade.edit(editedIncome);
    }
  }

  @DeleteMapping("/in={incomeId}")
  public void removeIncome(@RequestParam(name = "incomeId") String id) throws Exception {
    if (this.facade.exists(id)) {
      this.facade.remove(id);
    }
  }
}
