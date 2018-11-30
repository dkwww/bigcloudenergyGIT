package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Mrp;

public interface MrpMapper {
    int deleteByPrimaryKey(String mrpId);

    int insert(Mrp record);

    int insertSelective(Mrp record);

    Mrp selectByPrimaryKey(String mrpId);

    int updateByPrimaryKeySelective(Mrp record);

    int updateByPrimaryKey(Mrp record);
    
    List<Mrp>  qureyAll(Map<String, Object> map);
    
    int  selectCountBySelective(Mrp  mrp);
}