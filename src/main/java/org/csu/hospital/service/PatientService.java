package org.csu.hospital.service;

import org.csu.hospital.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    public boolean verifyAccount(Patient patient){
        return true;
    }
}
