package com.econ.app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.beans.factory.annotation.Value;

public class ConnectionHandler {

  @Value("${spring.datasource.url}")
  private static String jdbcUrl;

  public Connection getConnection() throws Exception {
    if (jdbcUrl == null || jdbcUrl.isBlank())
      throw new IOException("Could not load url from .yaml file");
    return DriverManager.getConnection(jdbcUrl);
  }
}
