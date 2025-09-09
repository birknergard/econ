package com.econ.app.income;

import com.econ.app.models.Income;
import java.sql.SQLException;

public class IncomeFacade {
  public IncomeRepo repository;

  public IncomeFacade() throws SQLException {
    this.repository = new IncomeRepo();
  }

  protected boolean exists(String id) throws SQLException {
    return this.repository.exists(id);
  }

  protected Income[] getAll() throws SQLException {
    return this.repository.getAll();
  }

  protected Income get(String id) throws SQLException {
    return this.repository.get(id);
  }

  protected void create(Income income) throws SQLException {
    repository.create(income);
  }

  protected void edit(Income income) throws SQLException {
    repository.edit(income);
  }

  protected void remove(String id) throws SQLException {
    repository.remove(id);
  }
}
