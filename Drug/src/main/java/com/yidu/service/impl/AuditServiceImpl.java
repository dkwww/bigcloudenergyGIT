package com.yidu.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.AuditMapper;
import com.yidu.domain.Audit;
import com.yidu.service.AuditService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 审核表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class AuditServiceImpl   implements AuditService {
	
	@Resource
	private AuditMapper mapper;

	@Override
	public int addOrUpdate(Audit audit) {
		
		int rows = 0;
		audit.setOptime(new Date());
		
		if(audit.getAudId()!=null &&!"".equals(audit.getAudId())) {
			rows = updateByPrimaryKeySelective(audit);
		}else {
			audit.setAudTime(new Date());
			audit.setAudState(null);//这里规定一下 “0” 审核未通过  “1” 审核通过
			audit.setIsva("1");
			audit.setSort(TimeUtil.getStrDate());
			rows = insertSelective(audit);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(Audit audit) {
		return mapper.updateByPrimaryKeySelective(audit);
	}



	@Override
	public int insertSelective(Audit audit) {
		return mapper.insertSelective(audit);
	}


	@Override
	public List<Audit> showList(Audit audit,PageUtil pageUtil) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("audit", audit);
		map.put("pageUtil", pageUtil);
		
		return mapper.findAll(map);
	}


	@Override
	public int findCount(Audit audit) {
		return mapper.findCount(audit);
	}

}
