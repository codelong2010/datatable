package com.datatable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.datatable.dao")
public class DatatableApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatableApplication.class, args);
    }

}
