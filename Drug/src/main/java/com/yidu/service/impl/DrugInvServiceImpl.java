package com.yidu.service.impl;

 
import com.yidu.controller.vo.Repertory;
import com.yidu.dao.DrugInveMapper;
import com.yidu.domain.DrugInve;
import com.yidu.service.DrugInvService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugInvServiceImpl    implements DrugInvService {
		
	@Resource
	private  DrugInveMapper  dao;

	@Override
	public List<DrugInve> qureyAll(DrugInve drugInve,PageUtil pageUtil ) {
		
		Map<String, Object>  map  =new  HashMap<>();
		map.put("drugInve", drugInve);
		map.put("pageUtil", pageUtil);
		
	 List<DrugInve> list = dao.qureyAll(map); 
		return list;
	}

	@Override
	public int selectCountBySelective(DrugInve drugInve) {
		
		return  dao.selectCountBySelective(drugInve);
	}

	@Override
	public List<DrugInve> findselect(DrugInve drugInve) {
		System.err.println("service="+drugInve.getComId());
		System.err.println("service="+drugInve.getDrugId());
		return dao.findselect(drugInve);
	}

	@Override
	public int amountupdate(DrugInve drugInve) {
		return dao.amountupdate(drugInve);
	}
	@Override
	public List<DrugInve> findDrug(String id) {
		return dao.findDrug(id);
	}

	@Override
	public List<DrugInve> selectDrugId(DrugInve drugInve) {
		return dao.selectDrugId(drugInve);
	}
	/**
	 * 入库
	 */
	@Override
	public int updateamount(DrugInve drugInve) {
		return   dao.updateamount(drugInve);
	}

	@Override
	public int insert(DrugInve record) {
		 
		return dao.insert(record);
	}

	@Override
	public List<Repertory> queryBalance(String id) {
		return dao.queryBalance(id);
	}

	@Override
	public int insertSelective(DrugInve drugInve) {
		return dao.insertSelective(drugInve);
	}

	@Override
	public int updateAmounts(Integer qdetAmount, String diId) {
		return dao.updateAmounts(qdetAmount,diId);
	}

	@Override
	public DrugInve findById(String id) {
		return dao.findById(id);
	}

	@Override
	public DrugInve findBydrugId(String qcFkId) {
		return dao.findQcId(qcFkId);
	}

	@Override
	public int minusAmounts(Integer qdetAmount, String diId) {
		return dao.minusAmounts(qdetAmount, diId);
	}

	@Override
	public int queryDrug(String id) {
		return dao.queryDrug(id);
	}

}
