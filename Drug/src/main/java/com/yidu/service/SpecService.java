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

	Spec findById(String drugId);

	int addOrUpdate(Spec record);

}
