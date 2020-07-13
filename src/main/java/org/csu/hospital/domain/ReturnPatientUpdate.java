package org.csu.hospital.domain;

public class ReturnPatientUpdate {
    private int code;
    private Patient patient;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
