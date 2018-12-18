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
import com.yidu.service.BuyHeService;
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
public class BuyHeServiceImpl implements BuyHeService {

	@Resource
	BuyMapper dao;
	
	@Override
	public List<Buy> showList(Buy buy,PageUtil page) {
		Map<String, Object> map=new HashMap<>();
		map.put("buy", buy);
		map.put("page", page);
		
		return dao.showList(map);
	}

	@Override
	public int addorUpdate(Buy buy) {
		int rows=0;
		
		rows=dao.deleteByPrimaryKey(buy.getBuyId());
		
		if(buy.getBuyId()!=null && !"".equals(buy.getBuyId())) {
			rows=dao.updateByPrimaryKeySelective(buy);
		}else {
			String uuid=UUID.randomUUID().toString().replaceAll("-", "");
			buy.setBuyId(uuid);
			rows=dao.insert(buy);
		}
		
		return rows;
	}

	@Override
	public int selectCount(Buy buy) {
		
		return dao.selectCount(buy);
	}

	@Override
	public int delete(String buyId) {
		
		return dao.deleteByPrimaryKey(buyId);
	}

}
