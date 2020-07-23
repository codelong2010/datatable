package com.datatable.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author xiaolong
 * @create 2020-07-22 18:35
 * @description 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("employee")
public class Employee {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("tel")
    private long tel;

    @TableField("address")
    private String address;

    @TableField("money")
    private int money;
}
