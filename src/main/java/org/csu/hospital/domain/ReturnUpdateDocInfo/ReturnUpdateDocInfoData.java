package org.csu.hospital.domain.ReturnUpdateDocInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;


public class ReturnUpdateDocInfoData {
    private long id;
    private String name;
    private String master;
    private String position;
    private double income;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
