package com.yidu.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.PmcDetailsMapper;
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

}
