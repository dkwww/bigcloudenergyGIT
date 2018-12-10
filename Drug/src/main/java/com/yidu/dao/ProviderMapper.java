package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Provider;

public interface ProviderMapper {
    int deleteByPrimaryKey(String provId);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(String provId);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
    
    /**
     * 查询所有
     * @param map
     * @return
     */
    List<Provider> showList(Map<String, Object> map);
}