package org.csu.hospital.domain.ReturnUpdateDocInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnUpdateDocInfo {
    private Meta meta;
    private ReturnUpdateDocInfoData data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnUpdateDocInfoData getData() {
        return data;
    }

    public void setData(ReturnUpdateDocInfoData data) {
        this.data = data;
    }
}
