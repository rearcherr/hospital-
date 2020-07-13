package org.csu.hospital.domain.ReturnSelectByDate;

import org.csu.hospital.domain.Doctor;

import java.util.List;

public class ReturnSelectByDateList {
    private String date;
    private List<ReturnDocInfomation> doctors;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ReturnDocInfomation> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<ReturnDocInfomation> doctors) {
        this.doctors = doctors;
    }
}
