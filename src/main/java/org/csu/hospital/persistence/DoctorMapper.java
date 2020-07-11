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
//    List<Doctor> getDoctorListByDepartmentAndDate(List<Doctor> doctors);
    List<Registeredrecord> getRegisterDate();
    List<String> getDoctorRegisterTime(long docId);
}
