package org.csu.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Department;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.persistence.DepartmentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentsMapper departmentsMapper;

    public PageInfo<Department> findAllDepartmentsByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Department> lists = departmentsMapper.getDepartments();
        PageInfo<Department> pageInfo = new PageInfo<Department>(lists);
        return pageInfo;
    }
    public PageInfo<Department> findAllDepartmentsByPageSAndId(int id,int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Department> lists = departmentsMapper.getDepartmentsById(id);
        PageInfo<Department> pageInfo = new PageInfo<Department>(lists);
        return pageInfo;
    }

    public Department getDepartmentById(int id){
        return departmentsMapper.getDepartmentById(id);
    }
    public void updateDepartment(Department department){
        departmentsMapper.updateDepartment(department);
    }
}
