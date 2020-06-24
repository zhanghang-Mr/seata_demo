package com.application.service.impl;

import com.application.mapper.OrderTblMapper;
import com.application.pojo.OrderTbl;
import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private OrderTblMapper orderTblMapper;

    @Override
//    @Transactional
    public String addProduct2() {
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setCommodityCode("aaa");
        orderTbl.setCount(123);
        orderTblMapper.insertSelective(orderTbl);
        if(true)
            throw new RuntimeException("--自定义异常");
        return "hello-product2";
    }
}
