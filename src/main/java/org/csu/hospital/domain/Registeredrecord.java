package org.csu.hospital.domain;


public class Registeredrecord {

  private long recId;
  private long docId;
  private long patId;
  private String time;


  public long getRecId() {
    return recId;
  }

  public void setRecId(long recId) {
    this.recId = recId;
  }


  public long getDocId() {
    return docId;
  }

  public void setDocId(long docId) {
    this.docId = docId;
  }


  public long getPatId() {
    return patId;
  }

  public void setPatId(long patId) {
    this.patId = patId;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
