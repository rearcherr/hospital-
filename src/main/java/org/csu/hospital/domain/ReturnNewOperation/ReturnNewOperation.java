package org.csu.hospital.domain.ReturnNewOperation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnNewOperation {
    @JsonProperty("data")
   private ReturnNewOperationDate returnNewOperationDate;
    @JsonProperty("meta")
   private ReturnNewOperationMeta returnNewOperationMeta;

    public ReturnNewOperationDate getReturnNewOperationDate() {
        return returnNewOperationDate;
    }

    public void setReturnNewOperationDate(ReturnNewOperationDate returnNewOperationDate) {
        this.returnNewOperationDate = returnNewOperationDate;
    }

    public ReturnNewOperationMeta getReturnNewOperationMeta() {
        return returnNewOperationMeta;
    }

    public void setReturnNewOperationMeta(ReturnNewOperationMeta returnNewOperationMeta) {
        this.returnNewOperationMeta = returnNewOperationMeta;
    }
}
