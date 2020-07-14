package org.csu.hospital.domain.ReturnPatientInfo;

import java.util.ArrayList;
import java.util.List;

public class ReturnPatientInfoDate {
    private int totalpage;
    private int pagenum;
    private List<ReturnPatientInfoDateList> returnPatientInfoDateLists = new ArrayList<ReturnPatientInfoDateList>();

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

    public List<ReturnPatientInfoDateList> getReturnPatientInfoDateLists() {
        return returnPatientInfoDateLists;
    }

    public void setReturnPatientInfoDateLists(List<ReturnPatientInfoDateList> returnPatientInfoDateLists) {
        this.returnPatientInfoDateLists = returnPatientInfoDateLists;
    }
}
