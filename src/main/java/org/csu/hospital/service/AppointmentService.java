package org.csu.hospital.service;

import org.csu.hospital.domain.Department;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.DepartmentsMapper;
import org.csu.hospital.persistence.DoctorMapper;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private DepartmentsMapper departmentsMapper;

    public List<Doctor> getDoctorList(){
        return doctorMapper.getDoctorList();
    }

    public List<Department> getDepartments(){
        return departmentsMapper.getDepartments();
    }

    public Patient getPatient(String patTel){
        return patientMapper.getPatient(patTel);
    }

    public void insertPatient(Patient patient){
        patientMapper.insertPatient(patient);
    }


}
