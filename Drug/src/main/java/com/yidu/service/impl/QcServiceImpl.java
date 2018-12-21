package com.yidu.service.impl;
 
import com.yidu.dao.QcMapper;
import com.yidu.domain.Qc;
import com.yidu.service.QcService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

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
		 for (Qc qc2 : list) {
			 System.out.println("+++++++++++我只知道这东西很重要+++++++++++"+qc.getPmcId());
			 System.out.println("+++++++++++我只知道这东西也很重要+++++++++++"+qc2.getQcOptime());
			 qc2.setQcOptiemName(TimeUtil.dateToString(qc2.getQcOptime(), "yyyy-dd-mm"));
		} 
		return list;
	}

	@Override
	public int selectCountBySelective(Qc qc) {
		 
		return dao.selectCountBySelective(qc);
	}

	@Override
	public int add(Qc qc) {
		 
		return dao.insert(qc);
	}

}
