package com.yidu.dao;

import com.yidu.domain.Module;

public interface ModuleMapper {
    int deleteByPrimaryKey(String modeId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String modeId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}