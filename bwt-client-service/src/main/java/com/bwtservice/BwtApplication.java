package com.bwtservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.bwtservice.mapper.**")
public class BwtApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BwtApplication.class, args);
    }
}
