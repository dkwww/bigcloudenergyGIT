package com.yidu.service.impl;

 
import com.yidu.dao.BuyDetailMapper;
import com.yidu.dao.BuyMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyHeDetailService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BuyHeDetailServiceImpl  implements BuyHeDetailService {


	@Resource
	BuyDetailMapper dao;
	
	@Override
	public List<BuyDetail> showListId(BuyDetail detail,PageUtil page) {
		//创建map对象
		Map<String, Object> map=new HashMap<>();
		//赋明细对象值
		map.put("detail", detail);
		//赋分页值
		map.put("page", page);
		
		//调用查询的方法
		return dao.showListId(map);
	}

	@Override
	public int add(BuyDetail deta) {
		//uuid
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		//把uuid赋进明细id
		deta.setBdetId(uuid);
		//调用增加方法
		return dao.insert(deta);
	}

	

	@Override
	public int selectCount(BuyDetail detail) {
		
		return dao.selectCount(detail);
	}
	
	@Override
	public int deleteDetail(String buyId) {
		
		return dao.deleteByPrimaryKeys(buyId);
	}

	@Override
	public List<BuyDetail> findBuyId(String buyId) {
		return dao.findBuyId(buyId);
	}
	

}
