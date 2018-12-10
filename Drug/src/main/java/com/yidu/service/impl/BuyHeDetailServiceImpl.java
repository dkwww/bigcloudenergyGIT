package com.yidu.service.impl;

 
import com.yidu.dao.BuyDetailMapper;
import com.yidu.dao.BuyMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyHeDetailService;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	public List<BuyDetail> showList(BuyDetail deta) {
		
		
		return dao.showList(deta);
	}

	@Override
	public int add(BuyDetail deta) {
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		deta.setBdetId(uuid);
		
		return dao.insert(deta);
	}

}
