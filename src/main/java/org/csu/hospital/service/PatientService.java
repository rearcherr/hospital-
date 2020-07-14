package org.csu.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Doctor;
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

    public Patient getPatientByPatId(int patId) {
        return patientMapper.getPatientByPatId(patId);
    }

    public void UpdatePatient(Patient patient) {
        patientMapper.UpdatePatient(patient);
    }

    public List<Patient> getPatientInfo() {
        return patientMapper.getPatients();
    }

    public List<MedicalRecordItem> getItemListByRecord(int id) {
        List<MedicalRecordItem> medicalRecordItems = patientMapper.getItemListByRecord(id);
        for (MedicalRecordItem item : medicalRecordItems
        ) {
            item.setMedicine(medicineMapper.getMedicineById(item.getMedId()));
        }
        return medicalRecordItems;
    }

    public MedicalRecord getMedicalRecordsByPatient(int id) {
        MedicalRecord medicalRecord;
        medicalRecord = patientMapper.getMedicalRecordByPatient(id);
        medicalRecord.setPatName(patientMapper.getPatientByPatId(medicalRecord.getPatId()).getPatName());
        medicalRecord.setMedicalRecordItems(getItemListByRecord(medicalRecord.getRecId()));
        return medicalRecord;
    }

    public PageInfo<Patient> findAllPatients(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Patient> lists = patientMapper.getPatients();
        PageInfo<Patient> pageInfo = new PageInfo<Patient>(lists);
        return pageInfo;
    }

    public PageInfo<Patient> findAllPatientsByPatId(int patId,int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Patient> lists = patientMapper.getPatientsByPatId(patId);
        PageInfo<Patient> pageInfo = new PageInfo<Patient>(lists);
        return pageInfo;
    }

}
