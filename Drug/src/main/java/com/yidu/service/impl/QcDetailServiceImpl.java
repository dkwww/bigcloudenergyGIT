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
	private   QcDetailMapper   dao;

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

}
