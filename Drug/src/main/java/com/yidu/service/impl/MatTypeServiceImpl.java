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
		//创建map集合
		Map<String, Object> map = new HashMap<String, Object>();
		//得到原材料类型
		map.put("type", type);
		//得到原材料行数
		map.put("pageUtil", pageUtil);
		//放进数据库
		return dao.showList(map);
	}


	@Override
	public int addorupdate(MatType type) {
		//定义一个变量为0
		int rows=0;
		//判断如果原材料类型id不等于空且不等于空
		if(type.getMtId()!=null && !"".equals(type.getMtId())) {
			//就调用修改方法
			rows=dao.updateByPrimaryKeySelective(type);
		}else {
			//uuid
			String uuid=UUID.randomUUID().toString().replaceAll("-", "");
			//把uuid放入材料类型id
			type.setMtId(uuid);
			//默认是否有效为1
			type.setIsva("1");
			//得到当前时间
			type.setOptime(new Date());
			//放入数据库
			rows=dao.insert(type);
		}
		return rows;
	}


	


	@Override
	public int selectCount(MatType type) {
		
		return dao.selectCount(type);
	}




	

	
	
}
