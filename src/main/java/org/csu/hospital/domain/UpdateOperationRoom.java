package org.csu.hospital.domain;

public class UpdateOperationRoom {
    private int state;
    private String roomId;
    private String id;

    public UpdateOperationRoom(int state, String roomId, String id) {
        this.state = state;
        this.roomId = roomId;
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
