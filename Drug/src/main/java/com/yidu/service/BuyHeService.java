package com.yidu.service;

import java.util.List;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 采购订单 服务类
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
public interface BuyHeService   {
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Buy> showList(Buy buy,PageUtil page);
	
	/**
	 * 查询总行数
	 * @param buy
	 * @return
	 */
	int selectCount(Buy buy);
	
	/**
	 * 采购材料增加
	 * @param buy
	 * @return
	 */
	int addorUpdate(Buy buy);
	
	/**
	 * 采购材料删除
	 * @param buyId
	 * @return
	 */
	int delete(String buyId);
	
	/**
	 * 审核查询所有
	 * @param buy
	 * @param page
	 * @return
	 */
	List<Buy> AuditshowList(Buy buy,PageUtil page);
	
	/**
	 * 审核查询总行数
	 * @param buy
	 * @return
	 */
	int AuditselectCount(Buy buy);
	
	/**
	 * 审核增加或修改
	 * @param buy
	 * @return
	 */
	int update(Buy buy);

	
	
	
	
}
