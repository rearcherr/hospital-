package org.csu.hospital.domain.ReturnSelectByDoctors;

import java.util.List;

public class ReturnDoctorInfoByDoctor {
    private long doctor_id;
    private String doctor_name;
    private String doctor_degree;
    private String doctor_desc;
    private String doctor_image;
    private List<String> timeForbit;

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_degree() {
        return doctor_degree;
    }

    public void setDoctor_degree(String doctor_degree) {
        this.doctor_degree = doctor_degree;
    }

    public String getDoctor_desc() {
        return doctor_desc;
    }

    public void setDoctor_desc(String doctor_desc) {
        this.doctor_desc = doctor_desc;
    }

    public String getDoctor_image() {
        return doctor_image;
    }

    public void setDoctor_image(String doctor_image) {
        this.doctor_image = doctor_image;
    }

    public List<String> getTimeForbit() {
        return timeForbit;
    }

    public void setTimeForbit(List<String> timeForbit) {
        this.timeForbit = timeForbit;
    }
}
