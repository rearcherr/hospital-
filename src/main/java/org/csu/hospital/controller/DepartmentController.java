package org.csu.hospital.controller;

import com.github.pagehelper.PageInfo;
import org.csu.hospital.domain.Department;
import org.csu.hospital.domain.Doctor;
import org.csu.hospital.domain.Meta;
import org.csu.hospital.domain.ReturnDeparts.ReturnDeparts;
import org.csu.hospital.domain.ReturnDeparts.ReturnDepartsDate;
import org.csu.hospital.domain.ReturnDeparts.ReturnDepartsDateList;
import org.csu.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
