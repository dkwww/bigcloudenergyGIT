package com.yidu.service.impl;

 
import com.yidu.dao.ModuleMapper;
import com.yidu.dao.RoleMapper;
import com.yidu.domain.Module;
import com.yidu.service.ModuleService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块管理 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class ModuleServiceImpl  implements ModuleService {
	@Resource
	private ModuleMapper modumapper;
	@Override
	public List<Module> queryList(Module module, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("module",module);
		map.put("page",pageUtil);
		return modumapper.queryList(map);
	}

	@Override
	public int queryCount(Module module) {
		return modumapper.queryCount(module);
	}

	@Override
	public int updateId(Module module) {
		if(module.getIsva()==null&&"".equals(module.getIsva())) {
			module.setIsva("是");
		}
		module.setOptime(new Date());
		return modumapper.updateByPrimaryKeySelective(module);
	}

	@Override
	public int insert(Module module) {
		module.setModeId(Tools.getRandomString());
		module.setIsva("是");
		module.setOptime(new Date());
		return modumapper.insertSelective(module);
	}

	@Override
	public List<Module> queryId() {
		return modumapper.queryId();
	}

	@Override
	public List<Module> findByModule(String adminId) {
		return modumapper.findByModule(adminId);
	}
}
