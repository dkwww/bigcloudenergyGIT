package com.yidu.service.impl;

 
import com.yidu.dao.DebtyMapper;
import com.yidu.domain.Debty;
import com.yidu.service.DebtyService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 财务表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DebtyServiceImpl   implements DebtyService {
	
	@Resource
	DebtyMapper debtydao;

	@Override
	public int insertSelective(Debty debty) {
		return debtydao.insertSelective(debty);
	}
}
