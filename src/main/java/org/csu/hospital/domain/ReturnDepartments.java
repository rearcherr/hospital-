package org.csu.hospital.domain;

import java.util.List;

public class ReturnDepartments {
    private int code;
    private List<Department> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
    }
}
