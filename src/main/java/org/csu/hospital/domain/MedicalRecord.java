package org.csu.hospital.domain;

import java.util.List;

public class MedicalRecord {
    int recId;
    int patId;
    List<MedicalRecordItem> medicalRecordItems;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    public List<MedicalRecordItem> getMedicalRecordItems() {
        return medicalRecordItems;
    }

    public void setMedicalRecordItems(List<MedicalRecordItem> medicalRecordItems) {
        this.medicalRecordItems = medicalRecordItems;
    }
}
