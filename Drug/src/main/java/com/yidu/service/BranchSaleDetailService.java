package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Series;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 分店销售明细 服务类
 * </p>
 *
 * @authorliuyi
 * @since 2018-11-26
 */
public interface BranchSaleDetailService  {

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
	 * @param saleDetail
	 * @return
	 */
	int findCount(BranchSaleDetail saleDetail);
	/**
	 * 根据名字查询
	 * @return
	 */
	List<Series> queryName();
	/**
	 * 根据ID查询
	 * @param time
	 * @param id
	 * @return
	 */
	int queryId(int time,String id);
}

