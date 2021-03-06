package org.csu.hospital.domain.ReturnSelectByDoctors;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnSelectByDoctors {
    private int code;
    private List<ReturnDoctorInfo> doctors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ReturnDoctorInfo> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<ReturnDoctorInfo> doctors) {
        this.doctors = doctors;
    }

    public void addDoctors(ReturnDoctorInfo returnDoctorInfo){
        this.doctors.add(returnDoctorInfo);
    }

}
