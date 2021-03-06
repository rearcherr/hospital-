package org.csu.hospital.domain.ReturnSelectByDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnSelectByDate {
    private int code;
    private List<ReturnSelectByDateList> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ReturnSelectByDateList> getList() {
        return list;
    }

    public void setList(List<ReturnSelectByDateList> list) {
        this.list = list;
    }

    public void addList(ReturnSelectByDateList returnSelectByDateList){
        this.list.add(returnSelectByDateList);
    }
}
