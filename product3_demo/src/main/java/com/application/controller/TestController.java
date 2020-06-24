package com.application.controller;


import com.application.service.TestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/product3")
//    @GlobalTransactional
    public String addProduct3(){

        return testService.addProduct2();
    }
}
