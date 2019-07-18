package com.damvinod.ms.api.dozer.to;

public class AgentTemp {

  private String name;
  private String gender;

  public String getGender() {
    return gender;
  }

  public String getName() {
    return name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "AgentTemp [name=" + name + ", gender=" + gender + "]";
  }
}
