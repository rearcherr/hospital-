package org.csu.hospital.domain.ReturnSelectByDate;

import java.util.List;

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
