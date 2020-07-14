package org.csu.hospital.domain.ReturnPatientInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnPatientInfo {
    private Meta meta;
    @JsonProperty("data")
    private ReturnPatientInfoDate returnPatientInfoDate;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnPatientInfoDate getReturnPatientInfoDate() {
        return returnPatientInfoDate;
    }

    public void setReturnPatientInfoDate(ReturnPatientInfoDate returnPatientInfoDate) {
        this.returnPatientInfoDate = returnPatientInfoDate;
    }
}
