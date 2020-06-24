package com.application.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Component
@FeignClient(name = "product3-server")
public interface Product3Feign {

    @RequestMapping(value = "/product3",method = RequestMethod.GET)
    String addProduct3();
}
