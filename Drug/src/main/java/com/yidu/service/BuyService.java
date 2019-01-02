package com.yidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yidu.domain.Admin;
import com.yidu.domain.Buy;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 采购订单 服务类
 * </p>
 *
 * @author 郑有宏
 * @since 2018-11-26
 */
public interface BuyService   {
	
	/**
	 * 查询所有
	 * @param buy
	 * @param pageUtil
	 * @return
	 */
	public List<Buy> showList(Buy buy,PageUtil pageUtil,Admin admin);
	
	/**
	 * 查找总行数
	 * @param buy
	 * @return
	 */
	public int findCount(Buy buy);
	
	/**
	 * 增加或修改的方法
	 * @param buy
	 * @return
	 */
	public int addOrUpdate(Buy buy);
	
	
	/**
	 * 修改
	 * @param buy
	 * @return
	 */
	public int updateByPrimaryKeySelective(Buy buy);
	
	/**
	 * 增加
	 * @param buy
	 * @return
	 */
	public int insertSelective(Buy buy);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Buy findById(String id);
}
