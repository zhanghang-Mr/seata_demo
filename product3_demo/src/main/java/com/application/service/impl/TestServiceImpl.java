package com.application.service.impl;

import com.application.mapper.UserTblMapper;
import com.application.pojo.UserTbl;
import com.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private UserTblMapper userTblMapper;

    @Override
//    @Transactional
    public String addProduct2() {
        UserTbl userTbl = new UserTbl();
        userTbl.setName("zhangsan");
        userTblMapper.insertSelective(userTbl);
        return "hello-product3";
    }
}
