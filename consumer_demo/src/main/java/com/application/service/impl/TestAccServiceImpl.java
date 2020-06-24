package com.application.service.impl;

import com.application.feign.Product2Feign;
import com.application.feign.Product3Feign;
import com.application.mapper.AccountTblMapper;
import com.application.pojo.AccountTbl;
import com.application.service.TestAccService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testAccService")
public class TestAccServiceImpl implements TestAccService {

    @Autowired
    private Product2Feign product2Feign;

    @Autowired
    private Product3Feign product3Feign;

    @Autowired
    private AccountTblMapper accountTblMapper;

    @Override
//    @Transactional
    public String addProduct1() {
        AccountTbl accountTbl = new AccountTbl();
        accountTbl.setMoney(123);
        accountTbl.setUserId("1");
        accountTblMapper.insertSelective(accountTbl);
        String product3 = product3Feign.addProduct3();
        String product2 = product2Feign.addProduct2();

        System.out.println("---product2---:"+product2);
        System.out.println("---product3---:"+product3);
        return "---hello---product1---";
    }

}
