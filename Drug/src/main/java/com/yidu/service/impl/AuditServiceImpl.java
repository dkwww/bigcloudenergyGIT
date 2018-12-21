package com.yidu.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


	@Override
	public int add(Audit audit) {
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		audit.setAudId(uuid);
		return mapper.insert(audit);
	}


	@Override
	public List<Audit> bushowList(Audit audit, PageUtil page) {
		Map<String, Object> map=new HashMap<>();
		map.put("audit", audit);
		map.put("page", page);
		
		return mapper.showList(map);
	}


	@Override
	public int selectCount(Audit audit) {
		
		return mapper.selectCount(audit);
	}

	
	@Override
	public List<Audit> wholeceo(Audit audit, PageUtil pageUtil) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("audit", audit);
		map.put("pageUtil", pageUtil);
		List<Audit> list = mapper.wholeceo(map);
		for (Audit audit2 : list) {
			if(audit2.getAudTime()!=null&&!"".equals(audit2.getAudTime())) {
				audit2.setAudTimes(TimeUtil.dateToString(audit2.getAudTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getOptime()!=null&&!"".equals(audit2.getOptime())) {
				audit2.setOptimes(TimeUtil.dateToString(audit2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getAudState()!=null&&!"".equals(audit2.getAudState())) {
				if("30".equals(audit2.getAudState())) {
					audit2.setAudStates("审核失败");
				}
				if("28".equals(audit2.getAudState())) {
					audit2.setAudStates("审核中");
				}
				if("29".equals(audit2.getAudState())) {
					audit2.setAudStates("审核通过");
				}
			}
			
		}
		return list;
	}


	@Override
	public int wholeceoupdate(String audId) {
		return mapper.wholeceoupdate(audId);
	}


	@Override
	public List<Audit> financeo(Audit audit, PageUtil pageUtil) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("audit", audit);
		map.put("pageUtil", pageUtil);
		List<Audit> list = mapper.financeo(map);
		for (Audit audit2 : list) {
			if(audit2.getAudTime()!=null&&!"".equals(audit2.getAudTime())) {
				audit2.setAudTimes(TimeUtil.dateToString(audit2.getAudTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getOptime()!=null&&!"".equals(audit2.getOptime())) {
				audit2.setOptimes(TimeUtil.dateToString(audit2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getAudState()!=null&&!"".equals(audit2.getAudState())) {
				if("31".equals(audit2.getAudState())) {
					audit2.setAudStates("审核失败");
				}
				if("29".equals(audit2.getAudState())) {
					audit2.setAudStates("审核中");
				}
				if("30".equals(audit2.getAudState())) {
					audit2.setAudStates("审核通过");
				}
			}
			
		}
		return list;
	}


	@Override
	public int finanupdate(String audId) {
		return mapper.finanupdate(audId);
	}
	
}
