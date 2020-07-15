package org.csu.hospital.domain.ReturnUpdateDepartment;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.csu.hospital.domain.Meta;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnUpdateDepartment {
    private Meta meta;
    private ReturnUpdateDepartmentDate date;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ReturnUpdateDepartmentDate getDate() {
        return date;
    }

    public void setDate(ReturnUpdateDepartmentDate date) {
        this.date = date;
    }
}
