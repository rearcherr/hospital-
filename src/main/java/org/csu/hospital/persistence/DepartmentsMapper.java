package org.csu.hospital.persistence;

import org.csu.hospital.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsMapper {
    List<Department> getDepartments();
    List<Department> getDepartmentsById(int query);
}
