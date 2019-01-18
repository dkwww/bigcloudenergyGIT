package com.yidu.service.impl;

 
import com.yidu.controller.vo.Series;
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
 * @author Liuyi
 * @since 2018-11-26
 */
@Service
public class BranchSaleDetailServiceImpl  implements BranchSaleDetailService {
	/**
	 * 注入零售明细的mapper
	 */
	@Resource
	private BranchSaleDetailMapper mapper;
	/**
	 * 增加
	 */
	@Override
	public int insertSelective(BranchSaleDetail branchSaleDetail) {
		//返回dao类增加的方法
		return mapper.insertSelective(branchSaleDetail);
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<BranchSaleDetail> query(PageUtil util, BranchSaleDetail saleDetail) {
		//创建一个map接口
		Map<String, Object> map=new HashMap<>();
		//取到页数
		map.put("page", util);
		//取到零售明细
		map.put("detail", saleDetail);
		//返回dao类查询所有的方法
		return mapper.query(map);
	}
	/**
	 * 分页
	 */
	@Override
	public int findCount(BranchSaleDetail saleDetail) {
		//返回dao类分页的方法
		return mapper.findCount(saleDetail);
	}
	/**
	 * 根据名字查询
	 */
	@Override
	public List<Series> queryName(String id) {
		//返回dao类根据名字查询的方法
		return mapper.queryName(id);
	}
	/**
	 * 根据ID查询
	 */
	@Override
	public int queryId(int time, String id) {
		//创建一个map接口
		Map<String, Object> map=new HashMap<>();
		map.put("time", time);
		//取到id
		map.put("id", id);
		//返回dao类根据ID查询的方法
		return mapper.queryId(map);
	}
	@Override
	public List<Series> queryMoney(String id) {
		return mapper.queryMoney(id);
	}
}
