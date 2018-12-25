package com.yidu.service.impl;

 
 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.MrpDetailsMapper;
import com.yidu.domain.MrpDetails;
import com.yidu.service.MrpDetailsService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

/**
 * <p>
 * 制造计划明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */  
@Service
public class MrpDetailsServiceImpl  implements MrpDetailsService {
	@Resource   
	private   MrpDetailsMapper   dao;

	@Override
	public List<MrpDetails> findById(MrpDetails mrpDetails, PageUtil page) {
		Map<String , Object>  map   =new   HashMap<>();
		map.put("mrpDetails", mrpDetails);
		map.put("pageUtil", page);
		
		List<MrpDetails> list = dao.findById(map);
		
		
		List<MrpDetails>  lists  =  new   ArrayList<>();
		for (MrpDetails mrpDetails2 : list) {
			if (mrpDetails2.getMdState()==1) {
				mrpDetails2.setMdStateName("未完成");
			} else { 
				mrpDetails2.setMdStateName("已完成");
			}
			 if (mrpDetails2.getMdView()==1) {
				mrpDetails2.setMdViewName("继续制造");
			}else {
				mrpDetails2.setMdViewName("停止制造");
			}
			mrpDetails2.setMdTimeName(TimeUtil.dateToString(mrpDetails2.getMdTime(),"yyyy-MM-dd HH:mm:ss"));
			
			lists.add(mrpDetails2);
		}
		
		 
		return   lists;
	}

	@Override
	public int findBycount(MrpDetails mrpDetails) {
		
		return dao.findBycount(mrpDetails);
	}

	@Override
	public int findStatistics(MrpDetails mrpDetails) {
		 
		return dao.findStatistics(mrpDetails);
	}

	@Override
	public int add(MrpDetails mrpDetails) {
	
		return dao.insert(mrpDetails);
	}

	@Override
	public int findmax(MrpDetails mrpDetails) {
		 
		return dao.findmax(mrpDetails);
	}

	@Override
	public int findPercentage(MrpDetails mrpDetails) {
	 
		return dao.findPercentage(mrpDetails);
	}

	@Override
	public int updateByPrimaryKeySelective(MrpDetails mrpDetails) {
	 
		return dao.updateByPrimaryKeySelective(mrpDetails);
	}

	 
	 
	 

}
