package org.csu.hospital.domain.ReturnDeparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnDeparts {
    private Meta meta;
    private ReturnDepartsDate date;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnDepartsDate getDate() {
        return date;
    }

    public void setDate(ReturnDepartsDate date) {
        this.date = date;
    }
}
