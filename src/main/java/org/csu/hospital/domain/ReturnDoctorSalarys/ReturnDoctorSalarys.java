package org.csu.hospital.domain.ReturnDoctorSalarys;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnDoctorSalarys {
    @JsonProperty("data")
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
