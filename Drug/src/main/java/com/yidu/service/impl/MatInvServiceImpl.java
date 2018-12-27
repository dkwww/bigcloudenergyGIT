package com.yidu.service.impl;

 
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
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MatInvServiceImpl  implements MatInvService {

	@Resource
	private MatInvMapper matinvmapper;
	
	
	@Override
	public List<MatInv> showList(MatInv matinv,PageUtil page) {
		Map<String, Object> map=new HashMap<>();
		map.put("matinv", matinv);
		map.put("page", page);
		
		
		return matinvmapper.showList(map);
	}


	@Override
	public int selectCount(MatInv matinv) {
		
		return matinvmapper.selectCount(matinv);
	}


	@Override
	public int add(MatInv matinv) {
		int rows=0;
		if(matinv.getMiId()!=null && !"".equals(matinv.getMiId())) {
			rows=matinvmapper.updateByPrimaryKeySelective(matinv);
		}else {
			matinv.setMiId(Tools.getDateOrderNo());
			matinv.setMiAmount(0);
			rows=matinvmapper.insert(matinv);
		}
		return rows;
	}


	


	@Override
	public List<MatInv> findQcId(String qcFkId) {
		
		return matinvmapper.findQcId(qcFkId);
	}


	@Override
	public int updateAmount(Integer miAmount, String miId) {
		
		return matinvmapper.updateAmount(miAmount, miId);
	}


	

}
