package org.csu.hospital.service;

import org.csu.hospital.domain.Ward;
import org.csu.hospital.persistence.WardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardService {

    @Autowired
    WardMapper wardMapper;

    public void updateWard(Ward ward){
        wardMapper.updateWard(ward);
    }

    public void deleteWard(int id){
        wardMapper.deleteWard(id);
    }

}
