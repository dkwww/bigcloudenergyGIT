package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Series;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.util.PageUtil;

/**
 * 分店销售明细 服务类
 *
 * @authorliuyi
 * @since 2018-11-26
 */
public interface BranchSaleDetailService  {
	/**
	 * 增加
	 * @param branchSaleDetail 零售明细model
	 * @return
	 */
	int insertSelective(BranchSaleDetail branchSaleDetail);
	/**
	 * 查询所有
	 * @param util
	 * @param saleDetail
	 * @return
	 */
	List<BranchSaleDetail> query(PageUtil util, BranchSaleDetail saleDetail);
	/**
	 * 分页
	 * @param saleDetail 零售明细model
	 * @return
	 */
	int findCount(BranchSaleDetail saleDetail);
	/**
	 * 根据名字查询
	 * @return
	 */
	List<Series> queryName(String id);
	/**
	 * 根据ID查询
	 * @param time
	 * @param id
	 * @return
	 */
	int queryId(int time,String id);
	
	List<Series> queryMoney(String id);
}

