package com.yidu.service;

import java.util.List;

import com.yidu.domain.SaleDetail;

/**
 * <p>
 * 销售明细 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface SaleDetailService {
	
	/**
	 * 增加或修改的方法
	 * @param detail
	 * @return
	 */
	public int addOrUpdate(SaleDetail detail);
	
	
	/**
	 * 修改
	 * @param toy
	 * @return
	 */
	public int updateByPrimaryKeySelective(SaleDetail detail);
	
	/**
	 * 增加
	 * @param toy
	 * @return
	 */
	public int insertSelective(SaleDetail detail);
	
	/**
	 * 根据id查询
	 * @return
	 */
	public List<SaleDetail> findById(String id);
}
