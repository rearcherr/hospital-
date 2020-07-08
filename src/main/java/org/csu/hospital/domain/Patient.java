package org.csu.hospital.domain;


public class Patient {

  private long patId;
  private String patName;
  private String patGender;
  private long patAge;
  private String patPwd;
  private double patDeposit;
  private java.sql.Date patDate;
  private String patTel;


  public long getPatId() {
    return patId;
  }

  public void setPatId(long patId) {
    this.patId = patId;
  }


  public String getPatName() {
    return patName;
  }

  public void setPatName(String patName) {
    this.patName = patName;
  }


  public String getPatGender() {
    return patGender;
  }

  public void setPatGender(String patGender) {
    this.patGender = patGender;
  }


  public long getPatAge() {
    return patAge;
  }

  public void setPatAge(long patAge) {
    this.patAge = patAge;
  }


  public String getPatPwd() {
    return patPwd;
  }

  public void setPatPwd(String patPwd) {
    this.patPwd = patPwd;
  }


  public double getPatDeposit() {
    return patDeposit;
  }

  public void setPatDeposit(double patDeposit) {
    this.patDeposit = patDeposit;
  }


  public java.sql.Date getPatDate() {
    return patDate;
  }

  public void setPatDate(java.sql.Date patDate) {
    this.patDate = patDate;
  }


  public String getPatTel() {
    return patTel;
  }

  public void setPatTel(String patTel) {
    this.patTel = patTel;
  }

}
