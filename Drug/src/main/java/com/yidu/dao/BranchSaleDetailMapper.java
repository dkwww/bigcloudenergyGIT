package com.yidu.dao;

import com.yidu.domain.BranchSaleDetail;

public interface BranchSaleDetailMapper {
    int deleteByPrimaryKey(String bsdId);

    int insert(BranchSaleDetail record);

    int insertSelective(BranchSaleDetail record);

    BranchSaleDetail selectByPrimaryKey(String bsdId);

    int updateByPrimaryKeySelective(BranchSaleDetail record);

    int updateByPrimaryKey(BranchSaleDetail record);
}