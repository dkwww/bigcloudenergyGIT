package com.yidu.service.impl;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyMapper;
import com.yidu.domain.Admin;
import com.yidu.domain.Buy;
import com.yidu.service.BuyService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 采购订单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BuyServiceImpl implements BuyService {

	@Resource
	BuyMapper mapper;
	
	@Override
	public List<Buy> showList(Buy buy,PageUtil pageUtil,Admin admin) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("buy", buy);
		map.put("pageUtil", pageUtil);
		map.put("admin", admin);
		List<Buy> list = mapper.findAll(map);
		for (Buy buy2 : list) {
			if(buy2.getBuyTime()!=null) {
				buy2.setBuyTimes(TimeUtil.dateToString(buy2.getBuyTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(buy2.getOptime()!=null) {
				buy2.setOptimes(TimeUtil.dateToString(buy2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if("0".equals(buy2.getBuyState())) {
				buy2.setBuyStates("采购中");
			}else if("1".equals(buy2.getBuyState())) {
				buy2.setBuyStates("采购完成");
			}else if("2".equals(buy2.getBuyState())) {
				buy2.setBuyStates("采购失败");
			}
		}
		
		return list;
	}


	@Override
	public int addOrUpdate(Buy buy) {
		
		int rows = 0;
		if(buy.getBuyId()!=null &&!"".equals(buy.getBuyId())) {
			rows = updateByPrimaryKeySelective(buy);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			buy.setBuyId(uuid);
			rows = insertSelective(buy);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(Buy buy) {
		return mapper.updateByPrimaryKeySelective(buy);
	}



	@Override
	public int insertSelective(Buy buy) {
		return mapper.insertSelective(buy);
	}


	@Override
	public int findCount(Buy buy) {
		return mapper.selectCountBySelective(buy);
	}


	@Override
	public Buy findById(String id) {
		return mapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateStatus(String status,String buyId) {
		return mapper.updateStates(status, buyId);
	}

}
