package org.csu.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class Medicine {
    @JSONField(name = "id")
    int medId;
    @JSONField(name = "name")
    String medName;
    @JSONField(name = "image")
    String medImg;
    @JSONField(name = "price")
    BigDecimal medPrice;
    @JSONField(name = "quantity")
    int medStore;
    @JSONField(name = "description")
    String medDesc;

    public String getMedDesc() {
        return medDesc;
    }

    public void setMedDesc(String medDesc) {
        this.medDesc = medDesc;
    }

    public int getMedStore() {
        return medStore;
    }

    public void setMedStore(int medStore) {
        this.medStore = medStore;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedImg() {
        return medImg;
    }

    public void setMedImg(String medImg) {
        this.medImg = medImg;
    }

    public BigDecimal getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(BigDecimal medPrice) {
        this.medPrice = medPrice;
    }
}
