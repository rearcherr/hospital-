package org.csu.hospital.domain.ReturnPatientUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.Patient;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnPatientUpdate {
    private Meta meta;
    @JsonProperty("data")
    private ReturnPatientUpdateData returnPatientUpdateData;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnPatientUpdateData getReturnPatientUpdateData() {
        return returnPatientUpdateData;
    }

    public void setReturnPatientUpdateData(ReturnPatientUpdateData returnPatientUpdateData) {
        this.returnPatientUpdateData = returnPatientUpdateData;
    }
}
