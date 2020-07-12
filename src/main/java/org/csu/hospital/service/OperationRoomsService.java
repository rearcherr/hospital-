package org.csu.hospital.service;

import org.csu.hospital.domain.UpdateOperationRoom;
import org.csu.hospital.persistence.OperationRoomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationRoomsService {
    @Autowired
    private OperationRoomsMapper operationRoomsMapper;

    public void updateState(int state,String roomId,String id){
        UpdateOperationRoom updateOperationRoom = new UpdateOperationRoom(state,roomId,id);
        operationRoomsMapper.updateState(updateOperationRoom);
    }
}
