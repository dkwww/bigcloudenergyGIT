package com.yidu.service;

import java.util.List;

import com.yidu.domain.MatInv;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原材料库存 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MatInvService  {

	
	/**
	 * 查询所有
	 * @param matinv
	 * @return
	 */
	List<MatInv> showList(MatInv matinv,PageUtil page);
	
	/**
	 * 查询总行数
	 * @param matinv
	 * @return
	 */
	int selectCount(MatInv matinv);

	
}
