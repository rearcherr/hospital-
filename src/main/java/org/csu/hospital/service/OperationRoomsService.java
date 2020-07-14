package org.csu.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Operatingroom;
import org.csu.hospital.domain.UpdateOperationRoom;
import org.csu.hospital.persistence.OperationRoomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRoomsService {
    @Autowired
    private OperationRoomsMapper operationRoomsMapper;

    public void updateState(int state,String roomId,String id){
        UpdateOperationRoom updateOperationRoom = new UpdateOperationRoom(state,roomId,id);
        operationRoomsMapper.updateState(updateOperationRoom);
    }

    public List<Operatingroom> getOperationRoomsInfo(){
        return operationRoomsMapper.getOperationRoomsInfo();
    }
    public List<Operatingroom> getOperationRoomsInfoByRoomId(String roomId){
        return operationRoomsMapper.getOperationRoomsInfoByRoomId(roomId);
    }

    public PageInfo<Operatingroom> findAllOperatingroomByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Operatingroom> lists = operationRoomsMapper.getOperationRoomsInfo();
        PageInfo<Operatingroom> pageInfo = new PageInfo<Operatingroom>(lists);
        return pageInfo;
    }
    public PageInfo<Operatingroom> findAllOperatingroomByPageSAndRoomId(int pageNum, int pageSize,String roomId) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Operatingroom> lists = operationRoomsMapper.getOperationRoomsInfoByRoomId(roomId);
        PageInfo<Operatingroom> pageInfo = new PageInfo<Operatingroom>(lists);
        return pageInfo;
    }

    public void insertOperationRoom(Operatingroom operatingroom){
        operationRoomsMapper.insertOperationRoom(operatingroom);
    }

}
