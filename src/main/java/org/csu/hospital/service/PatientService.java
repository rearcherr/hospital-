package org.csu.hospital.service;

import org.csu.hospital.domain.MedicalRecord;
import org.csu.hospital.domain.MedicalRecordItem;
import org.csu.hospital.domain.Patient;
import org.csu.hospital.persistence.MedicineMapper;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    MedicineMapper medicineMapper;

    public Patient getPatientByPatId(int patId){
        return patientMapper.getPatientByPatId(patId);
    }
    public void UpdatePatient(Patient patient){
            patientMapper.UpdatePatient(patient);
    }
    public List<Patient> getPatientInfo(){
            return patientMapper.getOperationRoomsInfo();
    }
    public List<MedicalRecordItem> getItemListByRecord(int id){
        List<MedicalRecordItem> medicalRecordItems = patientMapper.getItemListByRecord(id);
        for (MedicalRecordItem item:medicalRecordItems
             ) {
            item.setMedicine(medicineMapper.getMedicineById(item.getMedId()));
        }
        return medicalRecordItems;
    }

    public MedicalRecord getMedicalRecordsByPatient(int id){
        MedicalRecord medicalRecord;
        medicalRecord = patientMapper.getMedicalRecordByPatient(id);
        medicalRecord.setMedicalRecordItems(getItemListByRecord(medicalRecord.getRecId()));
        return medicalRecord;
    }
}
