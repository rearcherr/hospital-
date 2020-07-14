package org.csu.hospital.domain.ReturnPatientMedRecordById;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnPatientMedRecordById {
    private Meta meta;
    @JsonProperty("data")
    private ReturnPatientMedRecordByIdData returnPatientMedRecordByIdData;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnPatientMedRecordByIdData getReturnPatientMedRecordByIdData() {
        return returnPatientMedRecordByIdData;
    }

    public void setReturnPatientMedRecordByIdData(ReturnPatientMedRecordByIdData returnPatientMedRecordByIdData) {
        this.returnPatientMedRecordByIdData = returnPatientMedRecordByIdData;
    }
}
