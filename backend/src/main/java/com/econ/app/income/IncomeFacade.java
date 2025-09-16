package com.econ.app.income;

import com.econ.app.models.Income;
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

  protected boolean exists(String id) throws Exception {
    return this.repository.exists(id);
  }

  protected Income[] getAll() throws Exception {
    return this.repository.getAll();
  }

  protected Income get(String id) throws Exception {
    return this.repository.get(id);
  }

  protected void create(Income income) throws Exception {
    repository.create(income);
  }

  protected void edit(Income income) throws Exception {
    repository.edit(income);
  }

  protected void remove(String id) throws Exception {
    repository.remove(id);
  }
}
