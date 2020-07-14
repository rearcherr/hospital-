package org.csu.hospital.domain.ReturnOperationRoomsInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csu.hospital.domain.Operatingroom;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnOperationRoomsInfo {

    private ReturnOperationRoomsInfoData data;
    private ReturnOperationRoomsInfoMeta meta;

    public ReturnOperationRoomsInfoData getData() {
        return data;
    }

    public void setData(ReturnOperationRoomsInfoData data) {
        this.data = data;
    }

    public ReturnOperationRoomsInfoMeta getMeta() {
        return meta;
    }

    public void setMeta(ReturnOperationRoomsInfoMeta meta) {
        this.meta = meta;
    }
}
