package com.yidu.service;

import com.yidu.domain.Spec;

/**
 * <p>
 * 说明书 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface SpecService   {
	
	/**
	 * 根据药品id查询说明书
	 * @param drugId 药品id
	 * @return Spec 说明书模型类
	 * @author ZhouJun
	 */
	Spec findById(String drugId);
	
	/**
	 * 增加或修改
	 * @param record 说明书模型类
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int addOrUpdate(Spec record);

}
