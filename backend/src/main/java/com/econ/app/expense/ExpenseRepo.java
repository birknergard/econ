package com.econ.app.expense;

import com.econ.app.database.ConnectionHandler;
import com.econ.app.models.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepo {
  private static Boolean hasInititalized = null;
  private ConnectionHandler db;

  @Autowired
  public ExpenseRepo(ConnectionHandler db) {
    this.db = db;
  }

  private Connection connect() throws Exception {
    return this.db.getConnection();
  }

  private void closeQuietly(AutoCloseable c) throws Exception {
    if (c != null) c.close();
  }

  private void initialize(Connection connection) throws Exception {
    if (hasInititalized != null && hasInititalized) return;

    System.out.println("INIT: (1/2) Attempting to create EXPENSES table");
    String query =
        """
          CREATE TABLE EXPENSES(
            id STRING PRIMARY KEY,
            name STRING NOT NULL,
            cost DOUBLE NOT NULL,
            category STRING NOT NULL
          )
        """;

    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.executeUpdate();
      System.out.println("INIT: (2/2) EXPENSES table created");
      hasInititalized = true;
    }
  }

  protected boolean exists(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT 1 FROM EXPENSES WHERE id = ?";

    try {
      connection = this.connect();
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

  protected Expense[] getAll() throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT * FROM EXPENSES";

    try {
      connection = this.connect();
      this.initialize(connection);
      statement = connection.prepareStatement(query);
      result = statement.executeQuery();
      ArrayList<Expense> output = new ArrayList<>();

      while (result.next()) {
        String id = result.getString("id");
        String name = result.getString("name");
        double cost = Double.parseDouble(result.getString("cost"));
        String category = result.getString("category");
        Expense expense = new Expense(id, name, cost, category);
        output.add(expense);
      }

      return output.toArray(new Expense[0]);

    } finally {
      closeQuietly(result);
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected Expense get(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT * FROM EXPENSES WHERE id = ?";
    try {
      connection = this.connect();
      this.initialize(connection);
      query = "SELECT * FROM EXPENSES WHERE id = ?";
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      result = statement.executeQuery();
      Expense expense = null;
      if (result.next()) {
        String name = result.getString("name");
        double cost = Double.parseDouble(result.getString("cost"));
        String category = result.getString("category");
        expense = new Expense(id, name, cost, category);
      }
      return expense;

    } finally {
      closeQuietly(result);
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void create(Expense[] expenses) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "INSERT INTO EXPENSES(id, name, cost, category) VALUES(?, ?, ?, ?)";
    try {
      connection = this.connect();
      this.initialize(connection);
      for (Expense expense : expenses) {
        statement = connection.prepareStatement(query);
        statement.setString(1, expense.getId());
        statement.setString(2, expense.getName());
        statement.setDouble(3, expense.getCost());
        statement.setString(4, expense.getCategory());
        statement.executeUpdate();
      }
    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void create(Expense expense) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "INSERT INTO EXPENSES(id, name, cost, category) VALUES(?, ?, ?, ?)";
    try {
      connection = this.connect();
      this.initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, expense.getId());
      statement.setString(2, expense.getName());
      statement.setDouble(3, expense.getCost());
      statement.setString(4, expense.getCategory());
      statement.executeUpdate();

    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void edit(Expense expense) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "UPDATE EXPENSES SET name = ?, cost = ?, category = ? WHERE id = ?";

    try {
      connection = this.connect();
      this.initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, expense.getName());
      statement.setDouble(2, expense.getCost());
      statement.setString(3, expense.getCategory());
      statement.setString(4, expense.getId());
      statement.executeUpdate();

    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }

  protected void remove(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    String query = "DELETE FROM EXPENSES WHERE id = ?";

    try {
      connection = this.connect();
      this.initialize(connection);
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      statement.executeUpdate();
    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }
}
