package com.yidu.service.impl;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.DrugMapper;
import com.yidu.domain.Drug;
import com.yidu.service.DrugService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 药品表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugServiceImpl implements DrugService {
	
	@Resource
	private DrugMapper drugMapper;

	@Override
	public List<Drug> findAll(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugMapper.selectBySelective(map);
	}

	@Override
	public int addOrUpdate(Drug record) {
		if (record.getDrugId()!=null&&!"".equals(record.getDrugId())) {
			return drugMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setIsva("1");
			record.setSort(TimeUtil.getStrDate());
			return drugMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		return drugMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	@Override
	public int findCount(Drug record) {
		return drugMapper.selectCountBySelective(record);
	}

	@Override
	public int isCheck(String drugId) {
		return drugMapper.isCheck(drugId);
	}

	@Override
	public int addCheck(String drugId) {
		
		return 0;
	}

}
