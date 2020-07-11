package org.csu.hospital.service;

import org.csu.hospital.domain.*;
import org.csu.hospital.persistence.DepartmentsMapper;
import org.csu.hospital.persistence.DoctorMapper;
import org.csu.hospital.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private DepartmentsMapper departmentsMapper;

    public List<Doctor> getDoctorList(){
        return doctorMapper.getDoctorList();
    }

    public List<Department> getDepartments(){
        return departmentsMapper.getDepartments();
    }

    public Patient getPatient(String patTel){
        return patientMapper.getPatient(patTel);
    }

    public void insertPatient(Patient patient){
        patientMapper.insertPatient(patient);
    }

    public List<Doctor> getDoctorListByDepartment(String department) {
        return doctorMapper.getDoctorListByDepartment(department);
    }


    public List<Doctor> getDoctorListByDepartmentAndDate(List<Doctor> doctors,String date){
        int a = doctors.size();
        List<Registeredrecord> registeredrecords = doctorMapper.getRegisterDate();
        List<Doctor> doctors1 = new ArrayList<Doctor>();
        int b = registeredrecords.size();
        if(b>0) {
            for (int i = 0; i < b; i++) {
                if (registeredrecords.get(i).getTime().equals(date)) {
                    for (int j = 0; j < doctors.size(); j++) {
                        if (doctors.get(j).getDocId() == registeredrecords.get(i).getDocId()) {
                            doctors.remove(j);
                            break;
                        }
                    }
                }
            }
//        List<ListRegisteredrecord> registeredrecordList = new ArrayList<ListRegisteredrecord>();
//        for(int i=0;i<a;i++){
//
//            registeredrecords = doctorMapper.getRegisterDate(doctors.get(i).getDocId());
//            ListRegisteredrecord listRegisteredrecord = new ListRegisteredrecord();
//            listRegisteredrecord.setRegisteredrecordList(registeredrecords);
//            registeredrecordList.add(listRegisteredrecord);
//        }
            return doctors;
        }
        else {
            return doctors;
        }
    }

    public List<String> getDoctorRegisterTime (long docId){
        return doctorMapper.getDoctorRegisterTime(docId);
    }

}
