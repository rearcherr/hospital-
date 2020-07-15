package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Department;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.ReturnDeparts.ReturnDeparts;
import org.csu.hospital.domain.ReturnDeparts.ReturnDepartsDate;
import org.csu.hospital.domain.ReturnDeparts.ReturnDepartsDateList;
import org.csu.hospital.domain.ReturnUpdateDepartment.ReturnUpdateDepartment;
import org.csu.hospital.domain.ReturnUpdateDepartment.ReturnUpdateDepartmentDate;
import org.csu.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

//查看科室列表
    @GetMapping("/department")
    @ResponseBody
    public ReturnDeparts getDepartsList(@RequestParam(value = "query", required = false)Integer query,
                                        @RequestParam("pagenum")int pageNum, @RequestParam("pagesize")int pageSize){
        ReturnDeparts returnDeparts = new ReturnDeparts();
        try{
            PageInfo<Department> departmentPageInfo = new PageInfo<Department>();
            if(query==null){
                departmentPageInfo=departmentService.findAllDepartmentsByPageS(pageNum,pageSize);
            }
            else {
                departmentPageInfo=departmentService.findAllDepartmentsByPageSAndId(query,pageNum,pageSize);
            }
            List<Department> departments = departmentPageInfo.getList();
            ReturnDepartsDate returnDepartsDate = new ReturnDepartsDate();
            List<ReturnDepartsDateList> returnDepartsDates = new ArrayList<ReturnDepartsDateList>();
            for(int i=0;i<departments.size();i++){
                Department department = departments.get(i);
                ReturnDepartsDateList returnDepartsDateList = new ReturnDepartsDateList();
                returnDepartsDateList.setId((int)department.getId());
                returnDepartsDateList.setIntroduction(department.getIntroduction());
                returnDepartsDateList.setMaster(department.getMaster());
                returnDepartsDateList.setName(department.getName());
                returnDepartsDates.add(returnDepartsDateList);
            }

            returnDepartsDate.setPagenum(departmentPageInfo.getPageNum());
            returnDepartsDate.setTotalpage(departmentPageInfo.getPages());
            returnDepartsDate.setReturnDepartsDateLists(returnDepartsDates);

            Meta meta = new Meta();
            meta.setStatus(200);
            meta.setMsg("获取成功");

            returnDeparts.setDate(returnDepartsDate);
            returnDeparts.setMeta(meta);
            return returnDeparts;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setStatus(400);
            meta.setMsg("获取失败");
            returnDeparts.setMeta(meta);
            return returnDeparts;
        }
    }

    //修改科室信息
    @PutMapping("/department/{id}")
    @ResponseBody
    public ReturnUpdateDepartment UpdateDepartment(@PathVariable("id")Integer id,
                                                   @RequestParam(value = "name",required = false)String name,
                                                   @RequestParam(value = "master",required = false)String master,
                                                   @RequestParam(value = "introduction",required = false)String introduction){
        ReturnUpdateDepartment returnUpdateDepartment = new ReturnUpdateDepartment();
        try{
            Department department = departmentService.getDepartmentById(id);
            if(name!=null){
                department.setName(name);
            }
            if(master!=null){
                department.setMaster(master);
            }
            if(introduction!=null){
                department.setIntroduction(introduction);
            }
            departmentService.updateDepartment(department);
            Department department1 = departmentService.getDepartmentById(id);
            ReturnUpdateDepartmentDate returnUpdateDepartmentDate = new ReturnUpdateDepartmentDate();
            returnUpdateDepartmentDate.setId((int) department1.getId());
            returnUpdateDepartmentDate.setIntroduction(department1.getIntroduction());
            returnUpdateDepartmentDate.setMaster(department1.getMaster());
            returnUpdateDepartmentDate.setName(department1.getName());
            Meta meta = new Meta();
            meta.setMsg("更新成功");
            returnUpdateDepartment.setDate(returnUpdateDepartmentDate);
            returnUpdateDepartment.setMeta(meta);
            return returnUpdateDepartment;
        }
        catch (Exception e){
            Meta meta = new Meta();
            meta.setMsg("更新失败");
            meta.setStatus(400);
            returnUpdateDepartment.setMeta(meta);
            return returnUpdateDepartment;
        }
    }

}
