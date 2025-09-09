package com.econ.app.models;

public class Field {
  protected String id;
  protected String name;

  protected Field(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
