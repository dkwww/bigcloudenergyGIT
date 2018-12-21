package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.BranchSaleDetail;

public interface BranchSaleDetailMapper {
    int deleteByPrimaryKey(String bsdId);

    int insert(BranchSaleDetail record);

    int insertSelective(BranchSaleDetail record);

    BranchSaleDetail selectByPrimaryKey(String bsdId);

    int updateByPrimaryKeySelective(BranchSaleDetail record);

    int updateByPrimaryKey(BranchSaleDetail record);

    
	List<BranchSaleDetail> query(Map<String, Object> map);

	int findCount(BranchSaleDetail saleDetail);
}