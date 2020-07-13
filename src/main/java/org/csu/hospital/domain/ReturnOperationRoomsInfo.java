package org.csu.hospital.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnOperationRoomsInfo {
    private int code;
    @JsonProperty("operationRoomList")
    private List<Operatingroom> operationRoomList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Operatingroom> getOperationRoomList() {
        return operationRoomList;
    }

    public void setOperationRoomList(List<Operatingroom> operationRoomList) {
        this.operationRoomList = operationRoomList;
    }
}
