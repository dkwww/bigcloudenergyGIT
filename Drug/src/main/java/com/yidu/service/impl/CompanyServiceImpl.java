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

	@Override
	public int addOrUpdate(Company com) {
		int rows=0;
		if (com.getComId()!=null&&!"".equals(com.getComId())) {
			rows=updateByPrimaryKeySelective(com);
		}else {
			String  uuid=UUID.randomUUID().toString().replaceAll("-", "");
			com.setComId(uuid);
			com.setComType("分店");
			com.setOptime(new Date());
			com.setIsva("0");
			com.setSort(TimeUtil.getStrDate());
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


	@Override
	public int insertSelective(Company record) {
		
		return companyMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Company record) {
	
		return companyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int selectCount(Company company) {
		
		return companyMapper.selectCount(company);
	}

	
	@Override
	public int checkselectCount(Company company) {
		
		return companyMapper.checkselectCount(company);
	}
	

	
	


}
