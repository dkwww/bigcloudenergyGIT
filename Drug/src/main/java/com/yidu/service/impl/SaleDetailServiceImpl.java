package com.yidu.service.impl;

 
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.SaleDetailMapper;
import com.yidu.domain.SaleDetail;
import com.yidu.service.SaleDetailService;

/**
 * <p>
 * 销售明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class SaleDetailServiceImpl  implements SaleDetailService {

	@Resource
	SaleDetailMapper mapper;
	
	@Override
	public int addOrUpdate(SaleDetail detail) {
		
		int rows = 0;
		if(detail.getSdId()!=null &&!"".equals(detail.getSdId())) {
			rows = updateByPrimaryKeySelective(detail);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			detail.setSdId(uuid);
			rows = insertSelective(detail);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(SaleDetail detail) {
		return mapper.updateByPrimaryKeySelective(detail);
	}



	@Override
	public int insertSelective(SaleDetail detail) {
		return mapper.insertSelective(detail);
	}

}
