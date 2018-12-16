package com.yidu.service.impl;
 
import com.yidu.dao.MaterialListMapper;
import com.yidu.dao.SpecMapper;
import com.yidu.domain.MaterialList;
import com.yidu.domain.Spec;
import com.yidu.service.SpecService;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 说明书 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class SpecServiceImpl   implements SpecService {
	
	@Resource
	private SpecMapper specMapper;
	
	@Resource
	private MaterialListMapper materialListMapper;

	@Override
	public Spec findById(String drugId) {
		List<MaterialList> list = materialListMapper.selectByDrug(drugId);
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			MaterialList materialList = list.get(i);
			if (i == list.size()-1) {
				str += materialList.getMatName()+"。";
			} else {
				str += materialList.getMatName()+"，";
			}
		}
		Spec spec = specMapper.selectByPrimaryKey(drugId);
		if (spec!=null) spec.setSpecComponent(str);
		return spec;
	}

	@Override
	public int addOrUpdate(Spec record) {
		if (record.getSpecId()!=null&&!"".equals(record.getSpecId())) {
			return specMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setIsva("1");
			record.setOptime(new Date());
			return specMapper.insertSelective(record);
		}
	}

}
