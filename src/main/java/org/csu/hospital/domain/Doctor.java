package org.csu.hospital.domain;


public class Doctor {

  private long docId;
  private String docName;
  private String docGender;
  private long docAge;
  private String docPwd;
  private String docDepartment;
  private String docRank;
  private String docTel;
  private boolean onDuty;
//  private String offDuty;
  private double wage;
  private String docDesc;
  private String docImage;


  public long getDocId() {
    return docId;
  }

  public void setDocId(long docId) {
    this.docId = docId;
  }


  public String getDocName() {
    return docName;
  }

  public void setDocName(String docName) {
    this.docName = docName;
  }


  public String getDocGender() {
    return docGender;
  }

  public void setDocGender(String docGender) {
    this.docGender = docGender;
  }


  public long getDocAge() {
    return docAge;
  }

  public void setDocAge(long docAge) {
    this.docAge = docAge;
  }


  public String getDocPwd() {
    return docPwd;
  }

  public void setDocPwd(String docPwd) {
    this.docPwd = docPwd;
  }


  public String getDocDepartment() {
    return docDepartment;
  }

  public void setDocDepartment(String docDepartment) {
    this.docDepartment = docDepartment;
  }


  public String getDocRank() {
    return docRank;
  }

  public void setDocRank(String docRank) {
    this.docRank = docRank;
  }


  public String getDocTel() {
    return docTel;
  }

  public void setDocTel(String docTel) {
    this.docTel = docTel;
  }


  public boolean isOnDuty() {
    return onDuty;
  }

  public void setOnDuty(boolean onDuty) {
    this.onDuty = onDuty;
  }

  public double getWage() {
    return wage;
  }

  public void setWage(double wage) {
    this.wage = wage;
  }

  public String getDocDesc() {
    return docDesc;
  }

  public void setDocDesc(String docDesc) {
    this.docDesc = docDesc;
  }

  public String getDocImage() {
    return docImage;
  }

  public void setDocImage(String docImage) {
    this.docImage = docImage;
  }
}
