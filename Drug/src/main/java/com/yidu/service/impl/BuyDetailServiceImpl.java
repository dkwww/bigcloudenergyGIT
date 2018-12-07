package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyDetailMapper;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.util.TimeUtil;

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

	@Override
	public int addOrUpdate(BuyDetail detail) {
		
		int rows = 0;
		if(detail.getBdetId()!=null &&!"".equals(detail.getBdetId())) {
			rows = updateByPrimaryKeySelective(detail);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			detail.setBdetId(uuid);
			rows = insertSelective(detail);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(BuyDetail detail) {
		return mapper.updateByPrimaryKeySelective(detail);
	}



	@Override
	public int insertSelective(BuyDetail detail) {
		return mapper.insertSelective(detail);
	}

}
