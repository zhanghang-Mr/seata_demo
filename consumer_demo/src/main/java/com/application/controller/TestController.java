package com.application.controller;


import com.application.service.TestAccService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestAccService testAccService;

    @GetMapping("/product1")
    @GlobalTransactional(name = "fsp-order-create",rollbackFor = Exception.class)
    public String addProduct1(){

        return testAccService.addProduct1();
    }
}
