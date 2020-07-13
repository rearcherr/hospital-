package org.csu.hospital.domain;

import java.util.List;

public class ReturnAllPatientInfo {
    private List<Patient> patientList;
    private int code;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
