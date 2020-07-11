package org.csu.hospital.domain;

import java.util.List;

public class ReturnSelectByDateList {
    private String date;
    private List<Doctor> doctors;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
