package com.datatable;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.datatable.pojo.Employee;
import com.datatable.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.datatable.dao")
class DatatableApplicationTests {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        System.out.println(employeeService.list(wrapper));
    }

}
