package com.application.mapper;

import java.util.List;

import com.application.pojo.UserTbl;
import com.application.pojo.UserTblExample;
import org.apache.ibatis.annotations.Param;

public interface UserTblMapper {
    int countByExample(UserTblExample example);

    int deleteByExample(UserTblExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTbl record);

    int insertSelective(UserTbl record);

    List<UserTbl> selectByExample(UserTblExample example);

    UserTbl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTbl record, @Param("example") UserTblExample example);

    int updateByExample(@Param("record") UserTbl record, @Param("example") UserTblExample example);

    int updateByPrimaryKeySelective(UserTbl record);

    int updateByPrimaryKey(UserTbl record);
}