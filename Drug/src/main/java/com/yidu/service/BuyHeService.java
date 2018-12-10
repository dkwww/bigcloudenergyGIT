package com.yidu.service;

import java.util.List;

import com.yidu.domain.Buy;

/**
 * <p>
 * 采购订单 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface BuyHeService   {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Buy> showList(Buy buy);
	
	
	int add(Buy buy);
	
}
