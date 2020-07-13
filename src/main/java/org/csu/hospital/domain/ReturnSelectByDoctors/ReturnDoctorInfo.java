package org.csu.hospital.domain.ReturnSelectByDoctors;

import org.csu.hospital.domain.Doctor;

import javax.print.Doc;
import java.util.List;

public class ReturnDoctorInfo {
    private ReturnDoctorInfoByDoctor returnDoctorInfoByDoctor;

    public ReturnDoctorInfoByDoctor getReturnDoctorInfoByDoctor() {
        return returnDoctorInfoByDoctor;
    }

    public void setReturnDoctorInfoByDoctor(ReturnDoctorInfoByDoctor returnDoctorInfoByDoctor) {
        this.returnDoctorInfoByDoctor = returnDoctorInfoByDoctor;
    }
}
