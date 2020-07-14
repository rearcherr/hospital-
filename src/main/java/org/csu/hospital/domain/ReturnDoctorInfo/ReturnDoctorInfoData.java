package org.csu.hospital.domain.ReturnDoctorInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.ReturnDoctorSalarys.ReturnDoctorSalarysDateList;

import java.util.List;

public class ReturnDoctorInfoData {
    private int totalpage;
    private int pagenum;
    @JsonProperty("doctors")
    private List<ReturnDoctorInfoDataList> returnDoctorInfoDataLists;

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

    public List<ReturnDoctorInfoDataList> getReturnDoctorInfoDataLists() {
        return returnDoctorInfoDataLists;
    }

    public void setReturnDoctorInfoDataLists(List<ReturnDoctorInfoDataList> returnDoctorInfoDataLists) {
        this.returnDoctorInfoDataLists = returnDoctorInfoDataLists;
    }
}
