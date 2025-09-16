package com.econ.app.income;


public class IncomeRepo {
  /*
  private ConnectionHandler db;

  public IncomeRepo() {
    this.db = new ConnectionHandler();
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

  protected boolean exists(String id) throws Exception {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT 1 FROM INCOMES WHERE id = ?";

    try {
      connection = this.connect();
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
      connection = this.connect();
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
      connection = this.connect();
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
      connection = this.connect();
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
      connection = this.connect();
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
      connection = this.connect();
      statement = connection.prepareStatement(query);
      statement.setString(1, id);
      statement.executeUpdate();
    } finally {
      closeQuietly(statement);
      closeQuietly(connection);
    }
  }
  */
}
