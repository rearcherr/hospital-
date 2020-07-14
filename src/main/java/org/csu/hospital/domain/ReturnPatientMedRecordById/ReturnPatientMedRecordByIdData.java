package org.csu.hospital.domain.ReturnPatientMedRecordById;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnPatientMedRecordByIdData {
    @JsonProperty("list")
    private List<ReturnPatientMedRecordByIdDataList> returnPatientMedRecordByIdDataLists;

    public List<ReturnPatientMedRecordByIdDataList> getReturnPatientMedRecordByIdDataLists() {
        return returnPatientMedRecordByIdDataLists;
    }

    public void setReturnPatientMedRecordByIdDataLists(List<ReturnPatientMedRecordByIdDataList> returnPatientMedRecordByIdDataLists) {
        this.returnPatientMedRecordByIdDataLists = returnPatientMedRecordByIdDataLists;
    }
}
