package org.csu.hospital.domain.ReturnWordList;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnWordList {
    private Meta meta;
    private ReturnWordListData data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnWordListData getData() {
        return data;
    }

    public void setData(ReturnWordListData data) {
        this.data = data;
    }
}
