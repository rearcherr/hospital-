package org.csu.hospital.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.csu.hospital.domain.Doctor;
import org.csu.hospital.persistence.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public PageInfo<Doctor> findAllDoctorSalaryByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> lists = doctorMapper.getDoctorList();
        System.out.println(lists);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(lists);
        return pageInfo;
    }

    public PageInfo<Doctor> findAllDoctorSalaryByPageSAndDocName(String docName, int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> lists = doctorMapper.getDoctorListByDocName(docName);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(lists);
        return pageInfo;
    }

    public PageInfo<Doctor> findAllDoctorSalaryByPageSAndDocId(int docId, int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> lists = doctorMapper.getDoctorListByDocId(docId);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(lists);
        return pageInfo;
    }

    public Doctor getDoctorByDocId(long docID) {
        return doctorMapper.getDoctorByDocId(docID);
    }

    public void updateDoctorWage(Doctor doctor) {
        doctorMapper.updateDoctorWage(doctor);
    }

    public void updateDoctorInfo(Doctor doctor) {
        doctorMapper.updateDoctorInfo(doctor);
    }

    public void deleteDoctor(int docId) {
        doctorMapper.deleteDoctor(docId);
    }
    public double getTotalWage(){
        return  doctorMapper.getTotalWage();
    }
}
