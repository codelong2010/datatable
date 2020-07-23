package com.datatable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datatable.dao.EmployeeMapper;
import com.datatable.pojo.Employee;
import com.datatable.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong
 * @create 2020-07-22 18:43
 * @description
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
}
