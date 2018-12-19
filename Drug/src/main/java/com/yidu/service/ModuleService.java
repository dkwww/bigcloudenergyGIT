package com.yidu.service;

import java.util.List;

import com.yidu.domain.Module;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 模块管理 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface ModuleService   {
	List<Module> queryList(Module module,PageUtil pageUtil);
	int queryCount(Module module);
	int updateId(Module module);
	int insert(Module module);
}
