package com.yidu.service.impl;

 

import com.yidu.dao.CompanyMapper;
import com.yidu.domain.Company;

import com.yidu.service.CompanyService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 店铺（分店、总店） 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class CompanyServiceImpl  implements CompanyService {
	@Resource
	private CompanyMapper companyMapper;

	/**
	 * 分店的查询
	 */
	@Override
	public List<Company> findAll(Company company,PageUtil pageUtil) {
		//创建map
		Map<String, Object> map = new HashMap<String, Object>();
		//map赋值
		map.put("company", company);
		//map赋值
		map.put("pageUtil", pageUtil);
		//list集合
		List<Company> selectAll = companyMapper.selectAll(map);
		//创建list
		List<Company>ss=new ArrayList<>(); 
		
		for (Company company2 : selectAll) {
			//调用工具类，装换时间格式
			company2.setStrTime(Tools.getTimeStr(company2.getOptime()));
			//加入集合
			ss.add(company2);
		}	
		return ss;
	}
	/**
	 * 审核的查询
	 */
	@Override
	public List<Company> checkfindAll(Company company, PageUtil pageUtil) {
		//创建map
		Map<String, Object> map = new HashMap<String, Object>();
		//map赋值
		map.put("company", company);
		//map赋值
		map.put("pageUtil", pageUtil);
		//list集合
		List<Company> selectAll = companyMapper.checkselectAll(map);
		//创建list
		List<Company>ss=new ArrayList<>(); 
		for (Company company2 : selectAll) {
			//调用工具类，装换时间格式
			company2.setStrTime(Tools.getTimeStr(company2.getOptime()));
			//加入集合
			ss.add(company2);
		}	
		return ss;
	}
	/**
	 *增加或者修改
	 */
	@Override
	public int addOrUpdate(Company com) {
		//定义一个rows
		int rows=0;
		//判断id不等于空就是修改否则就是增加
		if (com.getComId()!=null&&!"".equals(com.getComId())) {
			//调用修改的方法
			rows=updateByPrimaryKeySelective(com);
		}else {
			//uuid
			String  uuid=UUID.randomUUID().toString().replaceAll("-", "");
			//增加uuid
			com.setComId(uuid);
			//增加分店时默认设置为分店
			com.setComType("分店");
			//默认增加当前时间
			com.setOptime(new Date());
			//默认为0
			com.setIsva("0");
			//默认增加一个排序
			com.setSort(TimeUtil.getStrDate());
			//调用增加的方法
			rows=insertSelective(com);
		}
		return rows;
	}
	/**
	 * 分店批量修改
	 */
	@Override
	public int companyUpdate(List<String> ids) {
	
		return companyMapper.companyDeleteByPrimaryKeySelective(ids);
	}
	/**
	 * 审核批量审核
	 */
	@Override
	public int checkcompanyUpdate(List<String> ids) {
		
		return companyMapper.checkcompanyDeleteByPrimaryKeySelective(ids);
	}

	/**
	 * 增加的方法
	 */
	@Override
	public int insertSelective(Company record) {
		
		return companyMapper.insertSelective(record);
	}
	/**
	 * 修改的方法
	 */
	@Override
	public int updateByPrimaryKeySelective(Company record) {
	
		return companyMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 查询的方法
	 */
	@Override
	public int selectCount(Company company) {
		
		return companyMapper.selectCount(company);
	}

	/**
	 * 查询总共多少条数据
	 */
	@Override
	public int checkselectCount(Company company) {
		
		return companyMapper.checkselectCount(company);
	}
	

	
	


}
