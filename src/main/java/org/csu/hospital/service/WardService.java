package org.csu.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Ward;
import org.csu.hospital.persistence.WardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Ward> getWards(){
        return wardMapper.getWards();
    }
    public PageInfo<Ward> findAllWardsByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Ward> lists = wardMapper.getWards();
        PageInfo<Ward> pageInfo = new PageInfo<Ward>(lists);
        return pageInfo;
    }
    public PageInfo<Ward> findAllWardsByPageSById(int query,int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Ward> lists = wardMapper.getWardsByWardId(query);
        PageInfo<Ward> pageInfo = new PageInfo<Ward>(lists);
        return pageInfo;
    }
}
