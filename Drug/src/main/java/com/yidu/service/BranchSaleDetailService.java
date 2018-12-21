package com.yidu.service;

import java.util.List;

import com.yidu.domain.BranchSaleDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 分店销售明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface BranchSaleDetailService  {

	int insertSelective(BranchSaleDetail branchSaleDetail);

	List<BranchSaleDetail> query(PageUtil util, BranchSaleDetail saleDetail);

	int findCount(BranchSaleDetail saleDetail);
}

