package com.yidu.service.impl;

 
import com.yidu.dao.MatInvMapper;
import com.yidu.domain.MatInv;
import com.yidu.service.MatInvService;
import com.yidu.util.PageUtil;

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

}
