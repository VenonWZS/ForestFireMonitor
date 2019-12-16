package com.bjfu.forestfiremonitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value="com.bjfu.forestfiremonitor.dao")
@SpringBootApplication
public class ForestfiremonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestfiremonitorApplication.class, args);
    }

}
