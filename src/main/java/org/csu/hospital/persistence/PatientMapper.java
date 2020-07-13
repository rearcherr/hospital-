package org.csu.hospital.persistence;

import org.csu.hospital.domain.Patient;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface PatientMapper {
    Patient getPatient(String patTel);
    Patient getPatientByPatId(int patId);
    List<Patient> getOperationRoomsInfo();
    void UpdatePatient(Patient patient);
    void insertPatient(Patient patient);


}
