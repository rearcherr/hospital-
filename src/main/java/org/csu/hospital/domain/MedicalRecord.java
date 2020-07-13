package org.csu.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MedicalRecord {
    @JSONField(name = "id")
    int recId;
    int patId;
    @JSONField(name = "name")
    String patName;
    @JSONField(name = "entries")
    List<MedicalRecordItem> medicalRecordItems;

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

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
