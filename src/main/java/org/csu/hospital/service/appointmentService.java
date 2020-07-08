package org.csu.hospital.service;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.DoctorMapper;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private PatientMapper patientMapper;

    public List<Doctor> getDoctorList(){
        return doctorMapper.getDoctorList();
    }

    public Patient getPatient(String patTel){
        return patientMapper.getPatient(patTel);
    }

}
