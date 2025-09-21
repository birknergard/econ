package com.econ.app.income;

import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeFacade {
  public IncomeRepo repository;

  @Autowired
  public IncomeFacade(IncomeRepo repo) throws SQLException {
    this.repository = repo;
  }

  public boolean exists(String id) throws Exception {
    return this.repository.exists(id);
  }

  public Income[] getAll() throws Exception {
    return this.repository.getAll();
  }

  public Income get(String id) throws Exception {
    return this.repository.get(id);
  }

  public void create(Income income) throws Exception {
    repository.create(income);
  }

  public void edit(Income income) throws Exception {
    repository.edit(income);
  }

  public void remove(String id) throws Exception {
    repository.remove(id);
  }
}
