package com.datatable.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datatable.config.JsonData;
import com.datatable.pojo.Employee;
import com.datatable.service.EmployeeService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaolong
 * @create 2020-07-22 19:07
 * @description
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/employee_find")
    public Object EmployeeFind(int page, int limit){
        //紧跟在startpage后面的第一个select方法会被分页
        PageHelper.startPage(page,limit);
        List<Employee> employees = employeeService.list();
        PageInfo<Employee> pageInfo=new PageInfo<>(employees);
        long count=pageInfo.getTotal();
        return JsonData.success(count,employees);
    }

    @ResponseBody
    @RequestMapping("/employee_del")
    public Object EmployeeDel(int id, int page, int limit){
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id);
        employeeService.remove(wrapper);
        PageHelper.startPage(page,limit);
        List<Employee> employees = employeeService.list();
        PageInfo<Employee> pageInfo=new PageInfo<>(employees);
        long count=pageInfo.getTotal();
        return JsonData.success(count,employees);
    }

    @ResponseBody
    @RequestMapping("/employee_mostdel")
    public Object EmployeeMostDel(@RequestParam(value = "id[]") int[] id, int page, int limit){
        for(int i : id){
            QueryWrapper<Employee> wrapper=new QueryWrapper<>();
            wrapper.eq("id",i);
            employeeService.remove(wrapper);
        }
        PageHelper.startPage(page,limit);
        List<Employee> employees = employeeService.list();
        PageInfo<Employee> pageInfo=new PageInfo<>(employees);
        long count=pageInfo.getTotal();
        return JsonData.success(count,employees);
    }

    @ResponseBody
    @RequestMapping("/employee_update")
    public Object EmployeeUpdate(@RequestBody Employee employee){
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        wrapper.eq("id",employee.getId());
        employeeService.update(employee,wrapper);
        return JsonData.success(0,null);
    }

    @ResponseBody
    @RequestMapping("/employee_add")
    public Object EmployeeAdd(@RequestBody Employee employee){
        employeeService.save(employee);
        return JsonData.success(0,null);
    }

    @ResponseBody
    @RequestMapping("/employee_search")
    public Object EmployeeSearch(@RequestParam(value = "id",defaultValue = "0") int id,int page,int limit){
        if(id > 0){
            QueryWrapper<Employee> wrapper=new QueryWrapper<>();
            wrapper.eq("id",id);
            PageHelper.startPage(page,limit);
            List<Employee> employees=employeeService.list(wrapper);
            return JsonData.success(1,employees);
        }
        else {
            PageHelper.startPage(page,limit);
            List<Employee> employees = employeeService.list();
            PageInfo<Employee> pageInfo=new PageInfo<>(employees);
            long count=pageInfo.getTotal();
            return JsonData.success(count,employees);
        }
    }
}
