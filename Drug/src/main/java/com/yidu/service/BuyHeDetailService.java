package com.yidu.service;

import java.util.List;

import com.yidu.domain.BuyDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 采购明细 服务类
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
public interface BuyHeDetailService  {
	
	/**
	 * 
	 * 方法说明：显示列表
	 * @param detail 明细对象
	 * @param page 分页
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月14日
	 */
	List<BuyDetail> showListId(BuyDetail detail,PageUtil page);
	
	/**
	 * 查询行数
	 * @param detail
	 * @return
	 */
	int selectCount(BuyDetail detail);
	
	
	int add(BuyDetail deta);
	
	int deleteDetail(String buyId);

	
	List<BuyDetail> findBuyId(String buyId);
	
	
}
