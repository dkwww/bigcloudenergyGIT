package com.yidu.service;

import java.util.List;

import com.yidu.controller.vo.Ztree;
import com.yidu.domain.Role;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface RoleService  {
	List<Role> queryList(Role role,PageUtil pageUtil);
	int queryCount(Role role);
	List<Ztree> queryModule();
	List<Ztree> selectZtree(String id);
	int updateId(Role role);
	int insert(Role role);
	int batchdelete(List<String> ids);
}
