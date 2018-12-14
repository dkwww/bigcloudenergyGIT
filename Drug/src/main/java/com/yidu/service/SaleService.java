package com.yidu.service;

import java.util.List;

import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 销售单 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface SaleService    {

	/**
	 * 增加或修改的方法
	 * @param detail
	 * @return
	 */
	public int addOrUpdate(Sale sale);
	
	
	/**
	 * 修改
	 * @param toy
	 * @return
	 */
	public int updateByPrimaryKeySelective(Sale sale);
	
	/**
	 * 增加
	 * @param toy
	 * @return
	 */
	public int insertSelective(Sale sale);
}
