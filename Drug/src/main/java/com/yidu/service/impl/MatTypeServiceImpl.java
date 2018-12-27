package com.yidu.service.impl;

 
import com.yidu.dao.MatTypeMapper;
import com.yidu.domain.MatType;
import com.yidu.service.MatTypeService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 原材料类型 服务实现类
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
@Service
public class MatTypeServiceImpl  implements MatTypeService {
	
	@Resource
	private MatTypeMapper dao;
	
	
	@Override
	public List<MatType> showList(MatType type,PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("pageUtil", pageUtil);
		return dao.showList(map);
	}


	@Override
	public int addorupdate(MatType type) {
		int rows=0;
		if(type.getMtId()!=null && !"".equals(type.getMtId())) {
			rows=dao.updateByPrimaryKeySelective(type);
		}else {
			String uuid=UUID.randomUUID().toString().replaceAll("-", "");
			type.setMtId(uuid);
			type.setIsva("1");
			type.setOptime(new Date());
			rows=dao.insert(type);
		}
		return rows;
	}


	@Override
	public int delete(String mtId) {
		
		return dao.deleteByPrimaryKey(mtId);
	}


	@Override
	public MatType showUpdate(String mtId) {
		
		return dao.selectByPrimaryKey(mtId);
	}


	@Override
	public int selectCount(MatType type) {
		
		return dao.selectCount(type);
	}


	@Override
	public int TypeupdateByPrimaryKeySelective(List<String> ids) {
		
		return dao.TypeupdateByPrimaryKeySelective(ids);
	}


	

	
	
}
