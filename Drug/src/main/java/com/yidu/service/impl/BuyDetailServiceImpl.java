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
	BuyDetailMapper dao;
	
	@Override
	public List<BuyDetail> showList(BuyDetail deta) {
		
		
		return dao.showList(deta);
	}

}
