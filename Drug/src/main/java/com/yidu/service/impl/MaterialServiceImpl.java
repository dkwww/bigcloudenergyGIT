package com.yidu.service.impl;

 
import com.yidu.dao.MatInvMapper;
import com.yidu.dao.MaterialMapper;
import com.yidu.domain.Material;
import com.yidu.service.MaterialService;
import com.yidu.util.PageUtil;

import java.util.Date;
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
 * @author dengkagnwei
 * @since 2018-11-26
 */
@Service
public class MaterialServiceImpl   implements MaterialService {
	
	@Resource
	private MaterialMapper dao;
	
	
	@Override
	public List<Material> showList(Material material,PageUtil page) {
		//创建map集合
		Map<String, Object> map=new HashMap<String, Object>();
		//得到原材料
		map.put("material", material);
		//得到原材料行数
		map.put("page", page);
		//放进数据库
		return dao.showList(map);
	}

	@Override
	public int addorUpdate(Material mat) {
		//定义一个变量为0
		int rows=0;
		//判断如果原材料id不等于空且不等于空
		if(mat.getMatId()!=null && !"".equals(mat.getMatId())) {
			//就调用修改方法
			rows=dao.updateByPrimaryKeySelective(mat);
		}else {
			//uuid
			String uuid=UUID.randomUUID().toString().replaceAll("-", "");
			//把uuid放入材料id
			mat.setMatId(uuid);
			//默认数量为0
			mat.setMatAmount(0);
			//得到当前时间
			mat.setOptime(new Date());
			//默认是否有效为1
			mat.setIsva("1");
			//放入数据库
			dao.insert(mat);
		}
		//返回rows
		return rows;
	}

	@Override
	public int selectCount(Material mat) {
		
		//调用dao的查询总行数
		return dao.selectCount(mat);
	}

}
