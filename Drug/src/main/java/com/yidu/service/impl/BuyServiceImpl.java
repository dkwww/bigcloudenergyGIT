package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyMapper;
import com.yidu.domain.Buy;
import com.yidu.service.BuyService;
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
	BuyMapper buyMapper;
	
	@Override
	public List<Buy> findAll() {
		List<Buy> lists = new ArrayList<>();
		List<Buy> list = buyMapper.findAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Buy buy = (Buy) iterator.next();
			buy.setBuyTimes(TimeUtil.dateToString(buy.getBuyTime(), "yyyy-MM-dd HH:mm:ss"));
			buy.setOptimes(TimeUtil.dateToString(buy.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			lists.add(buy);
		}
		
		return lists;
	}

}
