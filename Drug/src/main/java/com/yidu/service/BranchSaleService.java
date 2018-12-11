package com.yidu.service;

import java.util.List;


import com.yidu.domain.BranchSale;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 分店销售 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface BranchSaleService   {
	/**
	 * 显示列表
	 * @param util 分页模型
	 * @param sale model
	 * @return
	 */
	public List<BranchSale > query(PageUtil util, BranchSale branchSale);
	/**
	 * 分页
	 * @param sale model
	 * @return
	 */
	public int findCount(BranchSale branchSale);
	
	public int insertSelective(BranchSale branchSale);
}
