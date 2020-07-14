package org.csu.hospital.domain.ReturnUpdateDoctorSalarys;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnUpdateDoctorSalarys {
    private Meta meta;
    @JsonProperty("data")
    private ReturnUpdateDoctorSalarysDate returnUpdateDoctorSalarysDate;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnUpdateDoctorSalarysDate getReturnUpdateDoctorSalarysDate() {
        return returnUpdateDoctorSalarysDate;
    }

    public void setReturnUpdateDoctorSalarysDate(ReturnUpdateDoctorSalarysDate returnUpdateDoctorSalarysDate) {
        this.returnUpdateDoctorSalarysDate = returnUpdateDoctorSalarysDate;
    }
}
