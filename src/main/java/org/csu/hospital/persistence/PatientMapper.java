package org.csu.hospital.persistence;

import org.csu.hospital.domain.MedicalRecord;
import org.csu.hospital.domain.MedicalRecordItem;
import org.csu.hospital.domain.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMapper {
    Patient getPatient(String patTel);
    Patient getPatientByPatId(int patId);
    List<Patient> getPatients();
    List<Patient> getPatientsByPatId(int patId);
    void UpdatePatient(Patient patient);
    void insertPatient(Patient patient);
    void deletePatients(int patId);

    MedicalRecord getMedicalRecordByPatient(int patientId);

    List<MedicalRecordItem> getItemListByRecord(int recId);
}
