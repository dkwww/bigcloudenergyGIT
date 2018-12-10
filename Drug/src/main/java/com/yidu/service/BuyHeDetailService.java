package com.yidu.service;

import java.util.List;

import com.yidu.domain.BuyDetail;

/**
 * <p>
 * 采购明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface BuyHeDetailService  {
	
	
	
	/**
	 * 显示列表
	 * @return
	 */
	public List<BuyDetail> showList(BuyDetail deta);
	
	public int add(BuyDetail deta);
	
}
