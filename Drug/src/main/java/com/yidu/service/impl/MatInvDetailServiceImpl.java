package com.yidu.service.impl;

 
import com.yidu.dao.MatInvDetailMapper;
import com.yidu.domain.MatInvDetail;
import com.yidu.service.MatInvDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 原材料库存明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MatInvDetailServiceImpl implements MatInvDetailService {

	@Resource
	private MatInvDetailMapper dao;
	
	@Override
	public List<MatInvDetail> findById(MatInvDetail matdetail) {
		Map<String, Object> map=new HashMap<>();
		map.put("matdetail", matdetail);
		
		return dao.findById(map);
	}

	@Override
	public int selectCount(MatInvDetail matdetail) {
		
		return dao.selectCount(matdetail);
	}

}
