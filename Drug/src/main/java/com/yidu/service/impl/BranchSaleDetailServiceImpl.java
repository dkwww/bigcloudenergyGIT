package com.yidu.service.impl;

 
import com.yidu.dao.BranchSaleDetailMapper;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.service.BranchSaleDetailService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 分店销售明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BranchSaleDetailServiceImpl  implements BranchSaleDetailService {
	@Resource
	private BranchSaleDetailMapper mapper;
	
	@Override
	public int insertSelective(BranchSaleDetail branchSaleDetail) {
		return mapper.insertSelective(branchSaleDetail);
	}

	@Override
	public List<BranchSaleDetail> query(PageUtil util, BranchSaleDetail saleDetail) {
		Map<String, Object> map=new HashMap<>();
		map.put("page", util);
		map.put("detail", saleDetail);
		return mapper.query(map);
	}

	@Override
	public int findCount(BranchSaleDetail saleDetail) {
		return mapper.findCount(saleDetail);
	}

}
