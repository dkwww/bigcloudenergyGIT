package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 采购订单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BuyServiceImpl implements BuyService {

	@Resource
	BuyMapper mapper;
	
	@Override
	public List<Buy> showList(Buy buy,PageUtil pageUtil) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("buy", buy);
		map.put("pageUtil", pageUtil);
		
		
		return mapper.findAll(map);
	}


	@Override
	public int addOrUpdate(Buy buy) {
		
		int rows = 0;
		if(buy.getBuyId()!=null &&!"".equals(buy.getBuyId())) {
			rows = updateByPrimaryKeySelective(buy);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			buy.setBuyId(uuid);
			rows = insertSelective(buy);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(Buy buy) {
		return mapper.updateByPrimaryKeySelective(buy);
	}



	@Override
	public int insertSelective(Buy buy) {
		return mapper.insertSelective(buy);
	}


	@Override
	public int findCount(Buy buy) {
		return mapper.selectCountBySelective(buy);
	}

}
