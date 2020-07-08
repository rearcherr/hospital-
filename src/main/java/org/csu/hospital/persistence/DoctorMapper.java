package org.csu.hospital.persistence;

import org.csu.hospital.domain.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {
    List<Doctor> getDoctorList();

}
