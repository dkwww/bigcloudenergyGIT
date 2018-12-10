package com.yidu.service.impl;

 
import com.yidu.dao.ProviderMapper;
import com.yidu.domain.Provider;
import com.yidu.service.ProviderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	private ProviderMapper dao;
	
	
	@Override
	public List<Provider> showList(Provider pro) {
		Map<String, Object> map=new HashMap<>();
		map.put("pro", pro);
		
		return dao.showList(map);
	}

}
