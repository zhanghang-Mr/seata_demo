package com.application;

import com.application.config.DataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@Import(DataSourceConfiguration.class)
@MapperScan(basePackages = {"com.application.mapper"})  //扫描mapper
public class Product3Application {
    public static void main(String[] args) {
        SpringApplication.run(Product3Application.class, args);
    }
}
