package com.econ.app.income;

import com.econ.app.database.*;
import java.sql.*;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeRepo {
  private static Boolean hasInitialized = null;
  private ConnectionHandler db;

  @Autowired
  public IncomeRepo(ConnectionHandler db) {
    this.db = db;
  }

  private Connection connect() throws Exception {
    return this.db.getConnection();
  }

  private void closeQuietly(AutoCloseable c) {
    if (c != null)
      try {
        c.close();
      } catch (Exception ignored) {
      }
  }

  private void initialize(Connection connection) throws Exception {
    if (hasInitialized != null && hasInitialized) return;

    System.out.println("INIT: (1/2) Attempting to create INCOMES table");
    String query =
        """
          CREATE TABLE INCOMES(
            id STRING PRIMARY KEY,
            name STRING NOT NULL,
            amount DOUBLE NOT NULL
          )
        """;

    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.executeUpdate();
      System.out.println("INIT: (2/2) INCOMES table created");
      hasInitialized = true;
    }
  }

  protected boolean exists(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT 1 FROM INCOMES WHERE id = ?";

    try {
      connection = connect();
      initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      result = statement.executeQuery();
      return result.next();

    } finally {
      closeQuietly(result);
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected Income[] getAll() throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT * FROM INCOMES";

    try {
      connection = connect();
      initialize(connection);
      statement = connection.prepareStatement(query);
      result = statement.executeQuery();

      ArrayList<Income> output = new ArrayList<>();
      while (result.next()) {
        String id = result.getString("id");
        String name = result.getString("name");
        double amount = Double.parseDouble(result.getString("amount"));
        Income income = new Income(id, name, amount);
        output.add(income);
      }

      return output.toArray(new Income[0]);

    } finally {
      closeQuietly(result);
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected Income get(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT * FROM INCOMES WHERE id = ?";
    try {
      connection = connect();
      initialize(connection);
      query = "SELECT * FROM INCOMES WHERE id = ?";
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      result = statement.executeQuery();
      Income income = null;

      if (result.next()) {
        String incomeId = result.getString("id");
        String name = result.getString("name");
        double amount = Double.parseDouble(result.getString("amount"));
        income = new Income(incomeId, name, amount);
      }

      return income;

    } finally {
      closeQuietly(result);
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void create(Income income) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "INSERT INTO INCOMES(id, name, amount) VALUES(?, ?, ?)";
    try {
      connection = connect();
      initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, income.getId());
      statement.setString(2, income.getName());
      statement.setDouble(3, income.getAmount());
      statement.executeUpdate();
    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void edit(Income income) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "UPDATE INCOMES SET name = ?, amount = ? WHERE id = ?";

    try {
      connection = connect();
      initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, income.getName());
      statement.setDouble(2, income.getAmount());
      statement.setString(3, income.getId());
      statement.executeUpdate();

    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void remove(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "DELETE FROM INCOMES WHERE id = ?";

    try {
      connection = connect();
      initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      statement.executeUpdate();
    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }
}
