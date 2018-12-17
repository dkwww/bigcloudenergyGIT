package com.yidu.service.impl;

 
import com.yidu.dao.AuditMapper;
import com.yidu.domain.Audit;
import com.yidu.domain.BuyDetail;
import com.yidu.service.AuditService;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	AuditMapper mapper;

	@Override
	public int addOrUpdate(Audit audit) {
		
		int rows = 0;
		if(audit.getAudId()!=null &&!"".equals(audit.getAudId())) {
			rows = updateByPrimaryKeySelective(audit);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			audit.setAudId(uuid);
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
