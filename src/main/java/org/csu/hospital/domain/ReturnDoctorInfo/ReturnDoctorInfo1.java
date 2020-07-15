package org.csu.hospital.domain.ReturnDoctorInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnDoctorInfo1 {
    private Meta meta;
    private ReturnDoctorInfoData data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnDoctorInfoData getData() {
        return data;
    }

    public void setData(ReturnDoctorInfoData data) {
        this.data = data;
    }
}
