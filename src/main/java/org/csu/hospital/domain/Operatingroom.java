package org.csu.hospital.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Operatingroom {

  private long roomId;

  private String using;


  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }


  public String getUsing() {
    return using;
  }

  public void setUsing(String using) {
    this.using = using;
  }

}
