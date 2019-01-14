package com.yidu.service.impl;

 
import com.yidu.controller.vo.Repertory;
import com.yidu.dao.MatInvMapper;
import com.yidu.domain.MatInv;
import com.yidu.service.MatInvService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 原材料库存 服务实现类
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
@Service
public class MatInvServiceImpl  implements MatInvService {

	@Resource
	private MatInvMapper matinvmapper;
	
	
	@Override
	public List<MatInv> showList(MatInv matinv,PageUtil page) {
		//创建map对象
		Map<String, Object> map=new HashMap<>();
		//赋材料库存对象值
		map.put("matinv", matinv);
		//赋分页对象值
		map.put("page", page);
		
		//调用dao方法里的查询所有
		return matinvmapper.showList(map);
	}


	@Override
	public int selectCount(MatInv matinv) {
		
		return matinvmapper.selectCount(matinv);
	}


	@Override
	public int add(MatInv matinv) {
		//定义一个变量为0
		int rows=0;
		//判断如果id不等于空 且 不为 "  "
		if(matinv.getMiId()!=null && !"".equals(matinv.getMiId())) {
			//调用dao的修改方法
			rows=matinvmapper.updateByPrimaryKeySelective(matinv);
		}else {
			//增加id
			matinv.setMiId(Tools.getDateOrderNo());
			//赋值数量为0
			matinv.setMiAmount(0);
			//调用dao的增加方法
			rows=matinvmapper.insert(matinv);
		}
		//返回rows
		return rows;
	}



	@Override
	public MatInv findQcId(String qcFkId) {
		
		return matinvmapper.findQcId(qcFkId);
	}


	@Override
	public int updateAmount(Integer miAmount, String miId) {
		
		return matinvmapper.updateAmount(miAmount, miId);
	}


	@Override
	public List<MatInv> selectByamount(MatInv record) {
		
		return matinvmapper.selectByamount(record);
	}


	@Override
	public int insertSelective(MatInv inv) {
		return matinvmapper.insertSelective(inv);
	}


	@Override
	public List<Repertory> queryMaterials() {
		return matinvmapper.queryMaterials();
	}

}
