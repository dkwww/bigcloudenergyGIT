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

	@Override
	public List<Company> findAll(Company company,PageUtil pageUtil) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("company", company);
		map.put("pageUtil", pageUtil);
		
		List<Company> selectAll = companyMapper.selectAll(map);
		List<Company>ss=new ArrayList<>(); 
		
		for (Company company2 : selectAll) {
			company2.setStrTime(Tools.getTimeStr(company2.getOptime()));
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
			com.setSort(TimeUtil.getStrDate());
			rows=insertSelective(com);
		}
		return rows;
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
	public int companyUpdate(List<String> ids) {
	
		return companyMapper.companyDeleteByPrimaryKeySelective(ids);
	}

	


}
