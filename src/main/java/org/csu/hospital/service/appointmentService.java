package org.csu.hospital.service;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.persistence.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentService {

    @Autowired
    private DoctorMapper doctorMapper;

    public List<Doctor> getDoctorList(){
        return doctorMapper.getDoctorList();
    }

}
