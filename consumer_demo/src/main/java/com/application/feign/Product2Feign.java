package com.application.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Component
@FeignClient(name = "product2-server")
public interface Product2Feign {

    @RequestMapping(value = "/product2",method = RequestMethod.GET)
    String addProduct2();
}
