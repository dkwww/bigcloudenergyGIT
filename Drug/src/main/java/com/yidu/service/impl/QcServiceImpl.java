package com.yidu.service.impl;
 
import com.yidu.dao.QcMapper;
import com.yidu.domain.Qc;
import com.yidu.service.QcService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 质检表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class QcServiceImpl   implements QcService {
	@Resource
	private   QcMapper   dao;

	@Override
	public List<Qc> selectqctype(Qc qc, PageUtil pageUtil) {
		 Map<String , Object>  map  =new  HashMap<>();
		 
		 map.put("qc", qc);
		 map.put("pageUtil", pageUtil);
		 List<Qc> list = dao.selectqctype(map);
		 
		return list;
	}

	@Override
	public int selectCountBySelective(Qc qc) {
		 
		return dao.selectCountBySelective(qc);
	}

}
