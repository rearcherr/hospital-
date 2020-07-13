package org.csu.hospital.service;

import org.csu.hospital.domain.MedicalRecord;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    public MedicalRecord getMedicalRecordsByPatient(int id){
        MedicalRecord medicalRecord;
        medicalRecord = patientMapper.getMedicalRecordByPatient(id);
        medicalRecord.setMedicalRecordItems(patientMapper.getItemListByRecord(medicalRecord.getRecId()));
        return medicalRecord;
    }
}
