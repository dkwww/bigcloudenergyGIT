package com.yidu.service.impl;

 
import com.yidu.dao.PmcDetailsMapper;
import com.yidu.domain.PmcDetails;
import com.yidu.service.PmcDetailsService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 生产计划明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class PmcDetailsServiceImpl  implements PmcDetailsService {
	
	@Resource 
	
	private    PmcDetailsMapper  dao;

	@Override
	public List<PmcDetails> findById(PmcDetails pmcDetails  ,PageUtil  page) {
	
		
		 Map<String , Object>  map  =new  HashMap<>();
		 map.put("pmcDetails", pmcDetails);
		 map.put("pageUtil", page);
		 List<PmcDetails> list = dao.findById(map);
		 List<PmcDetails>  lists =new  ArrayList<>();
		 for (PmcDetails pmcDetails2 : list) {
			 pmcDetails2.setPmcStartName (TimeUtil.dateToString(pmcDetails2.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			 pmcDetails2.setPmcEndName(TimeUtil.dateToString(pmcDetails2.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
			 pmcDetails2.setMrpIdea("15%");
			 lists.add(pmcDetails2);
		}
		 
		return  lists ;
	}

	@Override
	public int selectCountBySelective(PmcDetails pmcDetail) {
		 
		return  dao.selectCountBySelective(pmcDetail);
	}

	@Override
	public int updateHang(PmcDetails pmcDetail) {
		
		return dao.updatedrug(pmcDetail);
	}

	@Override
	public int addOrUpdate(PmcDetails record) {
		record.setOptime(new Date());
		if (record.getPdId()!=null && !"".equals(record.getPdId())) {
			return dao.updateByPrimaryKeySelective(record);
		} else {
			record.setPdState("0");
			record.setIsva("1");
			return dao.insertSelective(record);
		}
	}

}
