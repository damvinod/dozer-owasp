package com.damvinod.ms.api.dozer.to;

public class Agent {

  private String fullName;
  private String full;

  public Agent() {
    super();
  }

  public Agent(String fullName) {
    super();
    this.fullName = fullName;
  }

  public Agent(String fullName, String full) {
    super();
    this.fullName = fullName;
    this.full = full;
  }

  public String getFull() {
    return full;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFull(String full) {
    this.full = full;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }


}
