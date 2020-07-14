package org.csu.hospital.domain.ReturnDoctorSalarys;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnDoctorSalarys {
    private ReturnDoctorSalarysDate date;
    private ReturnDoctorSalarysMeta meta;

    public ReturnDoctorSalarysDate getDate() {
        return date;
    }

    public void setDate(ReturnDoctorSalarysDate date) {
        this.date = date;
    }

    public ReturnDoctorSalarysMeta getMeta() {
        return meta;
    }

    public void setMeta(ReturnDoctorSalarysMeta meta) {
        this.meta = meta;
    }
}
