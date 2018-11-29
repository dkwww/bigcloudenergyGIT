package com.yidu.service.impl;

 
import com.yidu.dao.MrpMapper;
import com.yidu.domain.Mrp;
import com.yidu.service.MrpService;

import java.util.List;

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
	public List<Mrp> qureyAll() {
		List<Mrp> list = dao.qureyAll();
		for (Mrp mrp : list) {
			if (mrp.getMrpState()==0) {
				mrp.setStateName("制作中");
			}else  if (mrp.getMrpState()==1) {
				mrp.setStateName("制作完成");
			}
			if (mrp.getMrpIdea()==0) {
				mrp.setIdeaName("停止");
			}else if (mrp.getMrpIdea()==1) {
				mrp.setIdeaName("继续");
			}
		}
		return list;
	}
	
	
	

}
