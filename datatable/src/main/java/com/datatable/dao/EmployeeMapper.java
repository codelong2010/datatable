package com.datatable.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datatable.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xiaolong
 * @create 2020-07-22 18:38
 * @description 员工dao层接口
 */
@Repository
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
