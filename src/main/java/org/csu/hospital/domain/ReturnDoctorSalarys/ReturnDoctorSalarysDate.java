package org.csu.hospital.domain.ReturnDoctorSalarys;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnDoctorSalarysDate {
    @JsonProperty("doctors")
    private List<ReturnDoctorSalarysDateList> returnDoctorSalarysDateLists;
    @JsonProperty("total")
    private int totalpage;
    private int pagenum;

    public List<ReturnDoctorSalarysDateList> getReturnDoctorSalarysDateLists() {
        return returnDoctorSalarysDateLists;
    }

    public void setReturnDoctorSalarysDateLists(List<ReturnDoctorSalarysDateList> returnDoctorSalarysDateLists) {
        this.returnDoctorSalarysDateLists = returnDoctorSalarysDateLists;
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
