package com.application;

import com.application.config.DataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@Import(DataSourceConfiguration.class)
//@ComponentScan(basePackages = "com.application")
@MapperScan(basePackages = {"com.application.mapper"})  //扫描mapper
@EnableFeignClients(basePackages = {"com.application.feign"})  //扫描feign接口的路径
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
