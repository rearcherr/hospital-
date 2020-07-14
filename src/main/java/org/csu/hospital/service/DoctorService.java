package org.csu.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.persistence.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public PageInfo<Doctor> findAllDoctorSalaryByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> lists = doctorMapper.getDoctorList();
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(lists);
        pageInfo.getSize();
        return pageInfo;
    }
    public PageInfo<Doctor> findAllDoctorSalaryByPageSAndDocName(String docName,int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> lists = doctorMapper.getDoctorListByDocName(docName);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(lists);
        pageInfo.getSize();
        return pageInfo;
    }
    public Doctor getDoctorByDocId(long docID){
        return doctorMapper.getDoctorByDocId(docID);
    }
    public void updateDoctorWage(Doctor doctor){
        doctorMapper.updateDoctorWage(doctor);
    }
}
