package org.csu.hospital.persistence;

import org.csu.hospital.domain.UpdateOperationRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRoomsMapper {
    void updateState(UpdateOperationRoom updateOperationRoom);
}
