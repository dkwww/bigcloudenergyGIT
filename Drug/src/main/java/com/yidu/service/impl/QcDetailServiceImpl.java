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
		//定义一个变量为0
		int rows=0;
		//判断如果id不等于空 且 不为"  "
		if(qcdetail.getQdetId()!=null && !"".equals(qcdetail.getQdetId())) {
			//调用修改方法
			rows=dao.updateByPrimaryKeySelective(qcdetail);
		}
		
		//返回rows
		return rows;
	}

	@Override
	public List<QcDetail> findById(QcDetail qcdetail) {
		Map<String , Object> map=new HashMap<>();
		map.put("qcdetail", qcdetail);
		
		return dao.findById(map);
	}

	@Override
	public List<QcDetail> findByIds(QcDetail qcdetail,PageUtil page) {
		//创建map对象
		Map<String, Object> map=new HashMap<>();
		//赋质检明细对象值
		map.put("qcdetail", qcdetail);
		//赋分页对象值
		map.put("page", page);
		
		//调用根据质检id查询质检明细方法
		return dao.findByIds(map);
	}

	@Override
	public int insert(QcDetail qcDetail) {

		return dao.insert(qcDetail);
	}

	@Override
	public List<QcDetail> selectbyId(QcDetail record,PageUtil  page) {
		Map<String, Object>  map  = new   HashMap<>();
		map.put("qcDetail", record);
		map.put("pageUtil", page);
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

	@Override
	public int findByIdselectCount(QcDetail qcdetail) {
		
		return dao.findByIdselectCount(qcdetail);
	}

	@Override
	public List<QcDetail> findkcId(String qcId) {
		
		//调用dao的根据质检id查询质检明细
		return dao.findkcId(qcId);
	}
	

}
