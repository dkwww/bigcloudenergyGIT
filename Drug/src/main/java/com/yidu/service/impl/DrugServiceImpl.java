package com.yidu.service.impl;

 
import java.util.ArrayList;
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
		List<Drug> list = drugMapper.selectBySelective(map);
		List<Drug> lists = new ArrayList<Drug>();
		for (Drug drug : list) {
			String str = drugMapper.isCheck(drug.getDrugId());
			if (str!=null && !"".equals(str)) {
				drug.setAudState(str);
			} else {
				drug.setAudState("-1");
			}
			lists.add(drug);
		}
		return lists;
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
	public int check(String drugId) {
		return drugMapper.check(drugId);
	}
	
	@Override
	public List<Drug> selectBySelectives(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugMapper.selectBySelectives(map);
	}

	@Override
	public List<Drug> showAudit(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugMapper.selectByAudit(map);
	}

	@Override
	public int findAuditCount(Drug record) {
		return drugMapper.selectAuditCount(record);
	}
}
