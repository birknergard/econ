package com.econ.app;

import static org.junit.jupiter.api.Assertions.*;

import com.econ.app.models.Expense;
import java.sql.Connection;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ExpenseFacadeTest {
  private static Connection connection;
  private final Map<String, Expense> testObjects =
      Map.ofEntries(
          Map.entry("GET", new Expense("GET_TEST", "t", 0, "t")),
          Map.entry("DELETE", new Expense("DELETE_TEST", "t", 0, "t")),
          Map.entry("EDIT", new Expense("EDIT_TEST", "t", 0, "t")),
          Map.entry("POST", new Expense("POST_TEST", "t", 0, "t")));

  @BeforeAll
  static void establishConnection() {}

  @Test
  void getObject() {}

  @Test
  void deleteObject() {}

  @Test
  void postObject() {}

  @AfterAll
  static void cleanup() {}
}
