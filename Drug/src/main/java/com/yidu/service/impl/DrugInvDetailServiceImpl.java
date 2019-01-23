package com.yidu.service.impl;

 
import com.yidu.dao.DrugInvDetailMapper;
import com.yidu.domain.DrugInvDetail;
import com.yidu.service.DrugInvDetailService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugInvDetailServiceImpl   implements DrugInvDetailService {
	@Resource
  private  DrugInvDetailMapper   dao;
	@Override
	public List<DrugInvDetail> findById(String id) {
	 
		List<DrugInvDetail> list = dao.selectByPrimaryKey(id);
		
		for (DrugInvDetail drugInvDetail : list) {
			if (drugInvDetail.getRemarks()==1) {
				drugInvDetail.setRemarksName("销售出库");
			}else if(drugInvDetail.getRemarks()==2){
				drugInvDetail.setRemarksName("采购入库");
			}else {
				drugInvDetail.setRemarksName("生产入库");
			}
			
		}
		return list  ;
	}
	
	
	
	@Override
	public int selectcount(String id) {
 
		return dao.selectcount(id);
	}
	@Override
	public int insert(DrugInvDetail record) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		record.setDidId(uuid);
     int rows = dao.insert(record);
		return rows;
	}
	@Override
	public int insertSelective(DrugInvDetail record) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		record.setDidId(uuid);
		return dao.insertSelective(record);
	}



	@Override
	public List<DrugInvDetail> findBydiId(DrugInvDetail record, PageUtil pageUtil) { 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("diId", record);
		map.put("pageUtil", pageUtil);
		List<DrugInvDetail> rows = dao.findbydiId(map);
		for (DrugInvDetail drugInvDetail : rows) {
			if (drugInvDetail.getRemarks()==1) {
				drugInvDetail.setRemarksName("销售出库");
			}else if(drugInvDetail.getRemarks()==2){
				drugInvDetail.setRemarksName("采购入库");
			}else {
				drugInvDetail.setRemarksName("生产入库");
			}
		}
		return rows;
	}



	@Override
	public int findcount(String id) {
		int rows = dao.findcount(id);
		return rows;
	}

}
