package org.csu.hospital.persistence;

import org.csu.hospital.domain.Operatingroom;
import org.csu.hospital.domain.ReturnOperationRoomsInfo;
import org.csu.hospital.domain.UpdateOperationRoom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRoomsMapper {
    void updateState(UpdateOperationRoom updateOperationRoom);
    List<Operatingroom> getOperationRoomsInfo();
}
