package com.yidu.service.impl;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.MaterialListMapper;
import com.yidu.domain.MaterialList;
import com.yidu.service.MaterialListService;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 物料清单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MaterialListServiceImpl  implements MaterialListService {
	
	@Resource
	private MaterialListMapper materialListMapper;

	@Override
	public List<MaterialList> findAll(MaterialList record,PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return materialListMapper.selectBySelective(map);
	}

	@Override
	public int findCount(MaterialList record) {
		return materialListMapper.selectCountBySelective(record);
	}

}
