package com.yidu.service.impl;

 
import com.yidu.controller.vo.Ztree;
import com.yidu.dao.ModuleMapper;
import com.yidu.dao.ModuleRoleMapper;
import com.yidu.service.ModuleRoleService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块角色表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class ModuleRoleServiceImpl  implements ModuleRoleService {
	@Resource
	private ModuleRoleMapper moroMapper;
	@Override
	public List<Ztree> queryList(String id) {
		return moroMapper.queryList(id);
	}

}
