package com.yidu.service;

import java.util.List;



import com.yidu.domain.BranchSale;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

/**
 * 分店销售 服务类
 *
 * @author liuyi
 * @since 2018-11-26
 */
public interface BranchSaleService   {
	/**
	 * 显示列表
	 * @param util 分页model
	 * @param branchSale 零售model
	 * @return 零售的List集合
	 */
	public List<BranchSale> query(PageUtil util, BranchSale branchSale);
	/**
	 * 分页
	 * @param branchSale 零售model
	 * @return int
	 */
	public int findCount(BranchSale branchSale);
	/**
	 * 增加
	 * @param branchSale 零售model
	 * @return int
	 */
	public int insertSelective(BranchSale branchSale);
	/**
	 * 增加到零售明细
	 * @param sum  和
	 * @param menId 会员ID
	 * @param comId 店铺ID
	 * @return Message
	 */
	public Message addSale(String sum, String menId, String comId);
}
