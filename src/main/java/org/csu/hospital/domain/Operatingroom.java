package org.csu.hospital.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Operatingroom {

  private String roomId;

  private boolean state;

  private String docname;

  private String patientname;

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public String getDocname() {
    return docname;
  }

  public void setDocname(String docname) {
    this.docname = docname;
  }

  public String getPatientname() {
    return patientname;
  }

  public void setPatientname(String patientname) {
    this.patientname = patientname;
  }
}
