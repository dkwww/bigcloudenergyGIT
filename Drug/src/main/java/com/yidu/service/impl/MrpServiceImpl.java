package com.yidu.service.impl;

 
import com.yidu.dao.MrpMapper;
import com.yidu.domain.Mrp;
import com.yidu.service.MrpService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 制造计划 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MrpServiceImpl implements MrpService {
	@Resource
	private  MrpMapper   dao;
	@Override
	public List<Mrp> qureyAll(Mrp  mrp ,PageUtil pageUtil) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mrp", mrp);
		map.put("pageUtil", pageUtil);
		
	     List<Mrp> list = dao.qureyAll(map);
		for (Mrp mrp2 : list) {
			if (mrp2.getMrpState()==0) {
				mrp2.setStateName("制作中");
			}else  if (mrp2.getMrpState()==1) {
				mrp2.setStateName("制作完成");
			}
			if (mrp2.getMrpIdea()==0) {
				mrp2.setIdeaName("停止");
			}else if (mrp2.getMrpIdea()==1) {
				mrp2.setIdeaName("继续");
			}
		}
		return list;
	}
	@Override
	public int selectCountBySelectiv(Mrp mrp) {
	 
		return dao.selectCountBySelective(mrp);
	}
	
	
	

}
