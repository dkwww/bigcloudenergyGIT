package com.yidu.service.impl;

 
import com.yidu.dao.MatInvMapper;
import com.yidu.dao.MaterialMapper;
import com.yidu.domain.Material;
import com.yidu.service.MaterialService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 原材料 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MaterialServiceImpl   implements MaterialService {
	
	@Resource
	private MaterialMapper dao;
	
	
	@Override
	public List<Material> showList(Material material,PageUtil page) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("material", material);
		map.put("page", page);
		return dao.showList(map);
	}

	@Override
	public int addorUpdate(Material mat) {
		int rows=0;
		if(mat.getMatId()!=null && !"".equals(mat.getMatId())) {
			rows=dao.updateByPrimaryKeySelective(mat);
		}else {
			String uuid=UUID.randomUUID().toString().replaceAll("-", "");
			mat.setMatId(uuid);
			mat.setMatAmount(0);
			mat.setIsva("1");
			dao.insert(mat);
		}
		return rows;
	}

	@Override
	public int selectCount(Material mat) {
		
		return dao.selectCount(mat);
	}

}
