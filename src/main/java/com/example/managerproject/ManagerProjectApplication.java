package com.example.managerproject;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.managerproject.common.mapper")
@Slf4j
public class ManagerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerProjectApplication.class, args);
    }

}
