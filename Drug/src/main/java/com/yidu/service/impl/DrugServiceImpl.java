package com.yidu.service.impl;

 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.DrugMapper;
import com.yidu.domain.Drug;
import com.yidu.service.DrugService;
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
public class DrugServiceImpl   implements DrugService {
	
	@Resource
	private DrugMapper drugMapper;

	@Override
	public List<Drug> findAll(Drug record) {
		return drugMapper.selectBySelective(record);
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
	public int bulkUpdate(String[] ids) {
		return drugMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

}
