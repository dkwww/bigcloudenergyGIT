package com.yidu.service.impl;

 
import com.yidu.dao.SaleMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;
import com.yidu.service.SaleService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 销售单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class SaleServiceImpl implements SaleService {
	/**
	 * 注入销售单Mapper
	 */
	@Resource
	private SaleMapper mapper;
	
	
	@Override
	public int addOrUpdate(Sale sale) {
		
		int rows = 0;
		if(sale.getSaleId()!=null &&!"".equals(sale.getSaleId())) {
			rows = updateByPrimaryKeySelective(sale);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			sale.setSaleId(uuid);
			rows = insertSelective(sale);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(Sale sale) {
		return mapper.updateByPrimaryKeySelective(sale);
	}



	@Override
	public int insertSelective(Sale sale) {
		return mapper.insertSelective(sale);
	}


	@Override
	public List<Sale> showList(Sale sale, PageUtil pageUtil) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("sale", sale);
		map.put("pageUtil", pageUtil);
		List<Sale> list = mapper.findAll(map);
		
		
		return list;
	}


	@Override
	public int findCount(Sale sale) {
		return mapper.findCount(sale);
	}
	
	
	
}
