package com.econ.app.exception;


public class ErrorResponse {
  int status;
  String message;

  public ErrorResponse(int status, String message) {
    this.message = message;
    this.status = status;
  }
}
