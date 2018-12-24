package com.yidu.service.impl;

 
import com.yidu.dao.QcDetailMapper;
import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 材料质检明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class QcDetailServiceImpl   implements QcDetailService {

	@Resource
	private QcDetailMapper dao;
	
	@Override
	public int add(QcDetail qcdetail) {
		int rows=0;
		if(qcdetail.getQdetId()!=null && !"".equals(qcdetail.getQdetId())) {
			rows=dao.updateByPrimaryKeySelective(qcdetail);
		}
		
		return rows;
	}

	@Override
	public List<QcDetail> findById(QcDetail qcdetail) {
		Map<String , Object> map=new HashMap<>();
		map.put("qcdetail", qcdetail);
		
		return dao.findById(map);
	}

	@Override
	public List<QcDetail> findByIds(String qcId) {
		
		return dao.findByIds(qcId);
	}

	

}
