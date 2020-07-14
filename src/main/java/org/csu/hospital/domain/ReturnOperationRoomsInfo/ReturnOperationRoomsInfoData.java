package org.csu.hospital.domain.ReturnOperationRoomsInfo;

import org.csu.hospital.domain.Operatingroom;

import java.util.List;

public class ReturnOperationRoomsInfoData {
    private List<Operatingroom> operationRooms;
    private int totalpage;
    private int pagenum;

    public List<Operatingroom> getOperationRooms() {
        return operationRooms;
    }

    public void setOperationRooms(List<Operatingroom> operationRooms) {
        this.operationRooms = operationRooms;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }
}
