package org.csu.hospital.domain.ReturnPatientInfoById;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Meta;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnPatientInfoById {
    private Meta meta;
    @JsonProperty("data")
    private ReturnPatientInfoByIdData returnPatientInfoByIdData;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnPatientInfoByIdData getReturnPatientInfoByIdData() {
        return returnPatientInfoByIdData;
    }

    public void setReturnPatientInfoByIdData(ReturnPatientInfoByIdData returnPatientInfoByIdData) {
        this.returnPatientInfoByIdData = returnPatientInfoByIdData;
    }
}
