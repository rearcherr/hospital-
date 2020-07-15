package org.csu.hospital.domain.ReturnDeparts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnDepartsDate {
    @JsonProperty("departments")
    private List<ReturnDepartsDateList> returnDepartsDateLists;
    private int totalpage;
    private int pagenum;

    public List<ReturnDepartsDateList> getReturnDepartsDateLists() {
        return returnDepartsDateLists;
    }

    public void setReturnDepartsDateLists(List<ReturnDepartsDateList> returnDepartsDateLists) {
        this.returnDepartsDateLists = returnDepartsDateLists;
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
