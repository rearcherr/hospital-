package org.csu.hospital.controller;

import org.csu.hospital.domain.ReturnCode;
import org.csu.hospital.domain.ReturnDepartments;
import org.csu.hospital.domain.ReturnOperationRoomsInfo;
import org.csu.hospital.service.OperationRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ManageOperationRoomsController {
    @Autowired
    private OperationRoomsService operationRoomsService;

    //更新手术室状态
    @PutMapping("/operationRooms/{id}")
    @ResponseBody
    public ReturnCode Update(@PathVariable("id")String id,@RequestParam("state")int state,@RequestParam("roomId")String roomId){
        ReturnCode returnCode = new ReturnCode();
        try {
            operationRoomsService.updateState(state, roomId, id);
            returnCode.setCode(200);
            return returnCode;
        }
        catch (Exception e){
            returnCode.setCode(400);
            return returnCode;
        }
    }

    //获取所有手术室信息
    @GetMapping("/operationRooms")
    @ResponseBody
    public ReturnOperationRoomsInfo getOperationRoomsInfo(){
        ReturnOperationRoomsInfo returnOperationRoomsInfo = new ReturnOperationRoomsInfo();
        try{
            returnOperationRoomsInfo.setCode(200);
            returnOperationRoomsInfo.setOperationRoomList(operationRoomsService.getOperationRoomsInfo());
            return returnOperationRoomsInfo;
        }
        catch (Exception e){
            returnOperationRoomsInfo.setCode(400);
            return returnOperationRoomsInfo;
        }
    }

}
