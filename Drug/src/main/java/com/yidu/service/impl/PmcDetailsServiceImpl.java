package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.MrpDetailsMapper;
import com.yidu.dao.PmcDetailsMapper;
import com.yidu.domain.MrpDetails;
import com.yidu.domain.PmcDetails;
import com.yidu.service.PmcDetailsService;
import com.yidu.util.PageUtil;

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
	private PmcDetailsMapper pmcDetailsMapper;
	@Resource
	private MrpDetailsMapper mrpDetailMapper;

	@Override
	public int selectCountBySelective(PmcDetails pmcDetail) {
		return  pmcDetailsMapper.selectCountBySelective(pmcDetail);
	}

	@Override
	public int addOrUpdate(PmcDetails record) {
		record.setOptime(new Date());
		if (record.getPdId()!=null && !"".equals(record.getPdId())) {
			return pmcDetailsMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setPdState("0");
			record.setIsva("1");
			return pmcDetailsMapper.insertSelective(record);
		}
	}

	@Override
	public List<PmcDetails> findAll(PmcDetails record, PageUtil pageUtil) {
		Map<String , Object>  map  =new  HashMap<>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return pmcDetailsMapper.selectBySelective(map);
	}

	@Override
	public List<PmcDetails> findByPmc(PmcDetails record, PageUtil pageUtil, String mrpId) {
		Map<String , Object>  map  =new  HashMap<>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<PmcDetails> list =  pmcDetailsMapper.selectBySelective(map);
		List<PmcDetails> lists = new ArrayList<PmcDetails>();
		for (PmcDetails pmcDetails : list) {
			MrpDetails records = new MrpDetails();
			records.setMrpId(mrpId);
			records.setDrugId(pmcDetails.getDrugId());
			int amount = mrpDetailMapper.findStatistics(records);
			pmcDetails.setFinisded(amount);
			lists.add(pmcDetails);
		}
		return lists;
	}

}
