package com.yidu.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ProviderMapper;
import com.yidu.domain.Provider;
import com.yidu.service.ProviderService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 原料供应商 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class ProviderServiceImpl   implements ProviderService {

	@Resource
	private ProviderMapper providerMapper;//注入供应商导类
	
	
	@Override
	public List<Provider> showList(Provider pro) {
		Map<String, Object> map=new HashMap<>();
		map.put("pro", pro);
		
		return providerMapper.showList(map);
	}
	
	@Override
	public List<Provider> findAll(Provider record, PageUtil pageUtil) {
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询所有并返回
		return providerMapper.selectBySelective(map);
	}

	@Override
	public int findCount(Provider record) {
		//获得条件查询所有的总行数并返回
		return providerMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(Provider record) {
		//如果供应商的id不为空
		if (record.getProvId()!=null && !"".equals(record.getProvId())) {
			//进行修改并返回修改的行数
			return providerMapper.updateByPrimaryKeySelective(record);
		} else {
			//药品赋值有效
			record.setIsva("1");
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//操作时间赋值
			record.setOptime(new Date());
			//进行增加并返回增加的行数
			return providerMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		//批量删除并返回修改的行数
		return providerMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

}
