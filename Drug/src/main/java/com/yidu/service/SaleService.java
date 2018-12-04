package com.yidu.service;

import java.util.List;

import com.yidu.domain.Sale;
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
	 * 显示列表
	 * @param util
	 * @param sale
	 * @return
	 */
	public List<Sale> query(PageUtil util, Sale sale);

}
