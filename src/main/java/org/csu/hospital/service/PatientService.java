package org.csu.hospital.service;

import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public Patient getPatientByPatId(int patId){
        return patientMapper.getPatientByPatId(patId);
    }
    public void UpdatePatient(Patient patient){
        patientMapper.UpdatePatient(patient);
    }
    public List<Patient> getPatientInfo(){
        return patientMapper.getOperationRoomsInfo();
    }
}
