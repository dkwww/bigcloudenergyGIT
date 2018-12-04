package com.yidu.service.impl;

 
import com.yidu.dao.DrugInveMapper;
import com.yidu.domain.DrugInve;
import com.yidu.service.DrugInvService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugInvServiceImpl    implements DrugInvService {
		
	@Resource
	private  DrugInveMapper  dao;

	@Override
	public List<DrugInve> qureyAll(DrugInve drugInve,PageUtil pageUtil) {
		Map<String, Object>  map  =new  HashMap<>();
		map.put("drugInve", drugInve);
		map.put("pageUtil", pageUtil);
		
	 List<DrugInve> list = dao.qureyAll(map);
	 
	 
	 
	 for (DrugInve drugInves : list) {
		if (drugInves.getDiComtype().equals("1")) {
			drugInves.setComName("分公司");
		}else {
			drugInves.setComName("总公司");
		}
	}
	 
		return list;
	}

	@Override
	public int selectCountBySelective(DrugInve drugInve) {
		
		return  dao.selectCountBySelective(drugInve);
	}

}
