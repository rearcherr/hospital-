package org.csu.hospital.domain.ReturnWordList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnWordListData {
    private List<ReturnWordListDataList> patients;
    @JsonProperty("total")
    private int totalpage;
    private int pagenum;

    public List<ReturnWordListDataList> getPatients() {
        return patients;
    }

    public void setPatients(List<ReturnWordListDataList> patients) {
        this.patients = patients;
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
