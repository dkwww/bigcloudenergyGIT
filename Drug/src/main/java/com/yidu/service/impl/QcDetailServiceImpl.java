package com.yidu.service.impl;

 
import com.yidu.dao.QcDetailMapper;
import com.yidu.domain.QcDetail;
import com.yidu.service.QcDetailService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

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

	@Override
	public int insert(QcDetail qcDetail) {

		return dao.insert(qcDetail);
	}

	@Override
	public List<QcDetail> selectbyId(QcDetail record,PageUtil  pageUtil) {
		Map<String, Object>  map  = new   HashMap<>();
		map.put("qcDetail", record);
		map.put("pageUtil", pageUtil);
		List<QcDetail> list = dao.selectbyId(map);
		return list;
	}

	@Override
	public int selectbycount(QcDetail record) {
		
		return dao.selectbycount(record);
	}

	@Override
	public int updateByPrimaryKeySelective(QcDetail record) {
		 
		return dao.updateByPrimaryKeySelective(record);
	}

	 
	@Override
	public List<QcDetail> selectQcId(String id) {
	 
		return dao.selectQcId(id);
	}

	@Override
	public List<QcDetail> findByIdss(String qcId) {
		return dao.findByIdss(qcId);
	}

	@Override
	public List<QcDetail> findByQcId(String id) {
		return dao.findByQcId(id);
	}
	

}
