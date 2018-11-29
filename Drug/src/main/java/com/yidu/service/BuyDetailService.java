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
public interface BuyDetailService  {
	
	
	
	/**
	 * 显示列表
	 * @return
	 */
	public List<BuyDetail> findAll();
	
}
