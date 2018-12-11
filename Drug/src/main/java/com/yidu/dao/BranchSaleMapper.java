package com.yidu.dao;

import java.util.List;

import java.util.Map;

import com.yidu.domain.BranchSale;

public interface BranchSaleMapper {
    int deleteByPrimaryKey(String bsId);

    int insert(BranchSale record);

    int insertSelective(BranchSale record);

    BranchSale selectByPrimaryKey(String bsId);

    int updateByPrimaryKeySelective(BranchSale record);

    int updateByPrimaryKey(BranchSale record);
    /**
     * 显示列表
     * @param maps map集合
     * @return
     */
    public List<BranchSale> selectAll(Map<String, Object> maps);
    /**
     * 分页
     * @param sale model
     * @return
     */
	int findCount(BranchSale branchSale);
}