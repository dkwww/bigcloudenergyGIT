package com.yidu.dao;

import com.yidu.domain.Provider;

public interface ProviderMapper {
    int deleteByPrimaryKey(String provId);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(String provId);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
}