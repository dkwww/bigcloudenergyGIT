package com.yidu.dao;

import java.util.List;

import com.yidu.domain.Wholesale;

public interface WholesaleMapper {
    int deleteByPrimaryKey(String wholId);

    int insert(Wholesale record);

    int insertSelective(Wholesale record);

    Wholesale selectByPrimaryKey(String wholId);

    int updateByPrimaryKeySelective(Wholesale record);

    int updateByPrimaryKey(Wholesale record);
    
    public List<Wholesale> selectAll(Wholesale wholesale);
    
    public int updateisva(Wholesale wholesale);
}