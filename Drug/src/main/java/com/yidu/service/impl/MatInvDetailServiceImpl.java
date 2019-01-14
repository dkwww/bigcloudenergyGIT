package com.yidu.service.impl;

 
import com.yidu.dao.MatInvDetailMapper;
import com.yidu.domain.MatInvDetail;
import com.yidu.service.MatInvDetailService;
import com.yidu.util.PageUtil;

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
 * @author dengkangwei
 * @since 2018-11-26
 */
@Service
public class MatInvDetailServiceImpl implements MatInvDetailService {

	@Resource
	private MatInvDetailMapper dao;
	
	@Override
	public List<MatInvDetail> findById(MatInvDetail matdetail,PageUtil page) {
		//创建map集合
		Map<String, Object> map=new HashMap<>();
		//赋库存明细对象值
		map.put("matdetail", matdetail);
		//赋分页对象值
		map.put("page", page);
		//调用dao的根据id查询方法
		return dao.findById(map);
	}

	@Override
	public int selectCount(MatInvDetail matdetail) {
		
		//调用dao的查询总行数
		return dao.selectCount(matdetail);
	}

	@Override
	public int addkcdetail(MatInvDetail matdetail) {
		
		//调用dao的增加方法
		return dao.insert(matdetail);
	}

}
