package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Ztree;
import com.yidu.domain.ModuleRole;

/**
 * <p>
 * 模块角色表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface ModuleRoleService   {
	List<Ztree> queryList(String id);
	int deleteId(String roleId);
	int insert(ModuleRole moduleRoler);
}
