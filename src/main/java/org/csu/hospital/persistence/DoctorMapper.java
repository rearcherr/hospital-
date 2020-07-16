package org.csu.hospital.persistence;

import java.util.List;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Registeredrecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMapper {
    List<Doctor> getDoctorList();

    List<Doctor> getDoctorListByDepartment(String department);

    List<Doctor> getDoctorListByDocName(String docName);

    List<Doctor> getDoctorListByDocId(int docId);

    // List<Doctor> getDoctorListByDepartmentAndDate(List<Doctor> doctors);
    List<Registeredrecord> getRegisterDate();

    List<String> getDoctorRegisterTime(long docId);

    void doAppointment(Registeredrecord registeredrecord);

    Doctor getDoctorByDocId(long docID);

    void updateDoctorWage(Doctor doctor);

    void updateDoctorInfo(Doctor doctor);

    void deleteDoctor(int docId);
}
