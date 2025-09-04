package com.app.hexagonal.domain.exception;

public class ProductNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  @Override
  public synchronized Throwable getCause() {
    return super.getCause();
  }

  @Override
  public StackTraceElement[] getStackTrace() {
    return super.getStackTrace();
  }

}
