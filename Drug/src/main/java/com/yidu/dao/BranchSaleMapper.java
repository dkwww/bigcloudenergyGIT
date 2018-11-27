package com.yidu.dao;

import com.yidu.domain.BranchSale;

public interface BranchSaleMapper {
    int deleteByPrimaryKey(String bsId);

    int insert(BranchSale record);

    int insertSelective(BranchSale record);

    BranchSale selectByPrimaryKey(String bsId);

    int updateByPrimaryKeySelective(BranchSale record);

    int updateByPrimaryKey(BranchSale record);
}