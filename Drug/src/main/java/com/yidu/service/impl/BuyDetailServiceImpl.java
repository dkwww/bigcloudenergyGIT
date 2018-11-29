package com.yidu.service.impl;

 
import com.yidu.dao.BuyDetailMapper;
import com.yidu.dao.BuyMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class BuyDetailServiceImpl  implements BuyDetailService {


	@Resource
	BuyDetailMapper mapper;
	
	@Override
	public List<BuyDetail> findAll() {
		List<BuyDetail> lists = new ArrayList<>();
		List<BuyDetail> list = mapper.findAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BuyDetail buyDetail = (BuyDetail) iterator.next();
			
			buyDetail.setOptimes(TimeUtil.dateToString(buyDetail.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			lists.add(buyDetail);
		}
		
		return lists;
	}

}
