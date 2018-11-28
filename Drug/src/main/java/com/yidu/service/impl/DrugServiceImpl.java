package com.yidu.service.impl;

 
import com.yidu.dao.DrugMapper;
import com.yidu.domain.Drug;
import com.yidu.service.DrugService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
