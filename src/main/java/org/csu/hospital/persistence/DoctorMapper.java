package org.csu.hospital.persistence;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.ListRegisteredrecord;
import org.csu.hospital.domain.Registeredrecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {
    List<Doctor> getDoctorList();
    List<Doctor> getDoctorListByDepartment(String department);
    List<Doctor> getDoctorListByDocName(String docName);
    List<Doctor> getDoctorListByDocId(int docId);
//    List<Doctor> getDoctorListByDepartmentAndDate(List<Doctor> doctors);
    List<Registeredrecord> getRegisterDate();
    List<String> getDoctorRegisterTime(long docId);
    void doAppointment (Registeredrecord registeredrecord);
    Doctor getDoctorByDocId(long docID);
    void updateDoctorWage(Doctor doctor);
    void updateDoctorInfo(Doctor doctor);
    void deleteDoctor(int docId);
}
