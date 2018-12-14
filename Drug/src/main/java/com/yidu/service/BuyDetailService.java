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
	
	public int purchase(String mes);
	
	/**
	 * 增加或修改的方法
	 * @param detail
	 * @return
	 */
	public int addOrUpdate(BuyDetail detail);
	
	
	/**
	 * 修改
	 * @param toy
	 * @return
	 */
	public int updateByPrimaryKeySelective(BuyDetail detail);
	
	/**
	 * 增加
	 * @param toy
	 * @return
	 */
	public int insertSelective(BuyDetail detail);
}
