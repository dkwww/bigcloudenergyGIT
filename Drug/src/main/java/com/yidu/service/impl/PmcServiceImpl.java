package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.PmcMapper;
import com.yidu.domain.Pmc;
import com.yidu.service.PmcService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 生产计划单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class PmcServiceImpl  implements PmcService {

	@Resource
	private PmcMapper pmcMapper;

	@Override
	public List<Pmc> findAll(Pmc record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<Pmc> list = pmcMapper.selectBySelective(map);
		List<Pmc> newList = new ArrayList<Pmc>();
		for (Pmc pmc : list) {
			pmc.setStartTime(TimeUtil.dateToString(pmc.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			pmc.setEndTime(TimeUtil.dateToString(pmc.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
			newList.add(pmc);
		}
		return newList;
	}

	@Override
	public int findCount(Pmc record) {
		return pmcMapper.selectCountBySelective(record);
	}

}
