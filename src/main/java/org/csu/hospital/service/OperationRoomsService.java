package org.csu.hospital.service;

import org.csu.hospital.domain.Operatingroom;
import org.csu.hospital.domain.ReturnOperationRoomsInfo;
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
}
