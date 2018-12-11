package com.yidu.service.impl;

 
import com.yidu.dao.BranchSaleMapper;

import com.yidu.domain.BranchSale;
import com.yidu.service.BranchSaleService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 分店销售 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BranchSaleServiceImpl implements BranchSaleService {
	/**
	 * 注入销售单Mapper
	 */
	@Resource
	private  BranchSaleMapper mapper;

	@Override
	public List<BranchSale> query(PageUtil util, BranchSale branchSale) {
		//new一个Map集合
		Map<String, Object> map=new HashMap<>();
		map.put("util", util);
		map.put("branchSale", branchSale);
		//返回dao类查询所有的方法
		return mapper.selectAll(map);
	}
	/**
	 * 分页
	 */
	@Override
	public int findCount(BranchSale branchSale) {
		return mapper.findCount(branchSale);
	}
	@Override
	public int insertSelective(BranchSale branchSale) {
		return mapper.insertSelective(branchSale);
	}
}
