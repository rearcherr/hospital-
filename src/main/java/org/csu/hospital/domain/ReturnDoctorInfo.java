package org.csu.hospital.domain;

import javax.print.Doc;
import java.util.List;

public class ReturnDoctorInfo {
    private Doctor doctor;
    private List<String> timeForbit;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<String> getTimeForbit() {
        return timeForbit;
    }

    public void setTimeForbit(List<String> timeForbit) {
        this.timeForbit = timeForbit;
    }
}
