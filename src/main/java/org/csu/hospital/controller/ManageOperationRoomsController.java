package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Operatingroom;
import org.csu.hospital.domain.ReturnCode;
import org.csu.hospital.domain.ReturnNewOperation.ReturnNewOperation;
import org.csu.hospital.domain.ReturnNewOperation.ReturnNewOperationDate;
import org.csu.hospital.domain.ReturnNewOperation.ReturnNewOperationMeta;
import org.csu.hospital.domain.ReturnOperationRoomsInfo.ReturnOperationRoomsInfo;
import org.csu.hospital.domain.ReturnOperationRoomsInfo.ReturnOperationRoomsInfoData;
import org.csu.hospital.domain.ReturnOperationRoomsInfo.ReturnOperationRoomsInfoMeta;
import org.csu.hospital.service.OperationRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.NewThreadAction;

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

    //新增手术室
    @PostMapping("operationRooms")
    @ResponseBody
    public ReturnNewOperation Creat(@RequestParam("roomId")String roomId){

        Operatingroom operatingroom = new Operatingroom();
        operatingroom.setRoomId(roomId);
        operatingroom.setState(false);
        ReturnNewOperation returnNewOperation = new ReturnNewOperation();
        try {
            operationRoomsService.insertOperationRoom(operatingroom);
            ReturnNewOperationDate returnNewOperationDate = new ReturnNewOperationDate();
            ReturnNewOperationMeta returnNewOperationMeta = new ReturnNewOperationMeta();
            returnNewOperationDate.setRoomId(operatingroom.getRoomId());
            returnNewOperationDate.setState(operatingroom.isState());
            returnNewOperationMeta.setStatus(201);
            returnNewOperationMeta.setMsg("手术室创建成功");
            returnNewOperation.setReturnNewOperationDate(returnNewOperationDate);
            returnNewOperation.setReturnNewOperationMeta(returnNewOperationMeta);
            return returnNewOperation;
        }
        catch (Exception e){
            ReturnNewOperationMeta returnNewOperationMeta = new ReturnNewOperationMeta();
            returnNewOperationMeta.setStatus(400);
            returnNewOperationMeta.setMsg("手术室创建失败");
            returnNewOperation.setReturnNewOperationMeta(returnNewOperationMeta);
            return returnNewOperation;
        }
    }


    //获取所有手术室信息
    @GetMapping("/operationRooms")
    @ResponseBody
    public ReturnOperationRoomsInfo getOperationRoomsInfo(@RequestParam(value = "query", required = false)String query
            ,@RequestParam("pagenum")int pagenum
            ,@RequestParam("pagesize")int pagesize){
        ReturnOperationRoomsInfo returnOperationRoomsInfo = new ReturnOperationRoomsInfo();
        try{
            if(query==null) {
                ReturnOperationRoomsInfoMeta returnOperationRoomsInfoMeta = new ReturnOperationRoomsInfoMeta();
                returnOperationRoomsInfoMeta.setStatus(200);
                returnOperationRoomsInfoMeta.setMsg("获取成功");

                ReturnOperationRoomsInfoData returnOperationRoomsInfoData = new ReturnOperationRoomsInfoData();
                PageInfo<Operatingroom> operatingroomPageInfo = operationRoomsService.findAllOperatingroomByPageS(pagenum,pagesize);
                returnOperationRoomsInfoData.setTotalpage(operatingroomPageInfo.getPages());
                returnOperationRoomsInfoData.setPagenum(operatingroomPageInfo.getPageNum());
                returnOperationRoomsInfoData.setOperationRooms(operatingroomPageInfo.getList());

                returnOperationRoomsInfo.setData(returnOperationRoomsInfoData);
                returnOperationRoomsInfo.setMeta(returnOperationRoomsInfoMeta);
                return returnOperationRoomsInfo;
            }
            else {
                ReturnOperationRoomsInfoMeta returnOperationRoomsInfoMeta = new ReturnOperationRoomsInfoMeta();
                returnOperationRoomsInfoMeta.setStatus(200);
                returnOperationRoomsInfoMeta.setMsg("获取成功");

                ReturnOperationRoomsInfoData returnOperationRoomsInfoData = new ReturnOperationRoomsInfoData();
                PageInfo<Operatingroom> operatingroomPageInfo = operationRoomsService.findAllOperatingroomByPageSAndRoomId(pagenum,pagesize,query);
                returnOperationRoomsInfoData.setTotalpage(operatingroomPageInfo.getPages());
                returnOperationRoomsInfoData.setPagenum(operatingroomPageInfo.getPageNum());
                returnOperationRoomsInfoData.setOperationRooms(operatingroomPageInfo.getList());

                returnOperationRoomsInfo.setData(returnOperationRoomsInfoData);
                returnOperationRoomsInfo.setMeta(returnOperationRoomsInfoMeta);

                return returnOperationRoomsInfo;
            }
        }
        catch (Exception e){
            ReturnOperationRoomsInfoMeta returnOperationRoomsInfoMeta = new ReturnOperationRoomsInfoMeta();
            returnOperationRoomsInfoMeta.setStatus(400);
            returnOperationRoomsInfoMeta.setMsg("获取失败");
            return returnOperationRoomsInfo;
        }
    }

}
