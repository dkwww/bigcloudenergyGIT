package com.yidu.service.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.DrugTypeMapper;
import com.yidu.domain.DrugType;
import com.yidu.service.DrugTypeService;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 药品类型 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugTypeServiceImpl  implements DrugTypeService {
	
	@Resource
	private DrugTypeMapper drugTypeMapper;

	@Override
	public List<DrugType> showList() {
		return drugTypeMapper.selectList();
	}

	@Override
	public List<DrugType> findAll(DrugType record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugTypeMapper.selectBySelective(map);
	}

	@Override
	public int findCount(DrugType record) {
		return drugTypeMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(DrugType record) {
		if (record.getDtId()!=null && !"".equals(record.getDtId())) {
			return drugTypeMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setIsva("1");
			return drugTypeMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		return drugTypeMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

}
