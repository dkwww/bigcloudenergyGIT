package com.yidu.service.impl;
 
import com.yidu.dao.DrugTypeMapper;
import com.yidu.domain.DrugType;
import com.yidu.service.DrugTypeService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品类型 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugTypeServiceImpl   implements DrugTypeService {
	
	@Resource
	private DrugTypeMapper drugTypeMapper;

	@Override
	public List<DrugType> showList() {
		return drugTypeMapper.selectAll();
	}

}
