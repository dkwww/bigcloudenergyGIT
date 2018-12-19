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
		List<Audit> list = mapper.findAll(map);
		for (Audit audit2 : list) {
			if(audit2.getAudTime()!=null&&!"".equals(audit2.getAudTime())) {
				audit2.setAudTimes(TimeUtil.dateToString(audit2.getAudTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getOptime()!=null&&!"".equals(audit2.getOptime())) {
				audit2.setOptimes(TimeUtil.dateToString(audit2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getAudState()!=null&&!"".equals(audit2.getAudState())) {
				if("0".equals(audit2.getAudState())) {
					audit2.setAudStates("审核失败");
				}
				if("1".equals(audit2.getAudState())) {
					audit2.setAudStates("审核中");
				}
				if("2".equals(audit2.getAudState())) {
					audit2.setAudStates("审核通过");
				}
			}
			
		}
		
		return list;
	}


	@Override
	public int findCount(Audit audit) {
		return mapper.findCount(audit);
	}


	@Override
	public List<Audit> showCEO(Audit audit, PageUtil pageUtil) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("audit", audit);
		map.put("pageUtil", pageUtil);
		List<Audit> list = mapper.showCEO(map);
		for (Audit audit2 : list) {
			if(audit2.getAudTime()!=null&&!"".equals(audit2.getAudTime())) {
				audit2.setAudTimes(TimeUtil.dateToString(audit2.getAudTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getOptime()!=null&&!"".equals(audit2.getOptime())) {
				audit2.setOptimes(TimeUtil.dateToString(audit2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getAudState()!=null&&!"".equals(audit2.getAudState())) {
				if("0".equals(audit2.getAudState())) {
					audit2.setAudStates("审核失败");
				}
				if("1".equals(audit2.getAudState())) {
					audit2.setAudStates("审核中");
				}
				if("2".equals(audit2.getAudState())) {
					audit2.setAudStates("审核通过,等待总经理审核");
				}
			}
			
		}
		
		return list;
	}


	@Override
	public List<Audit> showBuy(Audit audit, PageUtil pageUtil) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("audit", audit);
		map.put("pageUtil", pageUtil);
		List<Audit> list = mapper.showBuy(map);
		for (Audit audit2 : list) {
			if(audit2.getAudTime()!=null&&!"".equals(audit2.getAudTime())) {
				audit2.setAudTimes(TimeUtil.dateToString(audit2.getAudTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getOptime()!=null&&!"".equals(audit2.getOptime())) {
				audit2.setOptimes(TimeUtil.dateToString(audit2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
			}
			if(audit2.getAudState()!=null&&!"".equals(audit2.getAudState())) {
				if("0".equals(audit2.getAudState())) {
					audit2.setAudStates("审核失败");
				}
				if("1".equals(audit2.getAudState())) {
					audit2.setAudStates("审核中");
				}
				if("2".equals(audit2.getAudState())) {
					audit2.setAudStates("审核通过,等待总经理审核");
				}
			}
			
		}
		
		return list;
	}

	@Override
	public Audit findById(String id) {
		return mapper.selectByPrimaryKey(id);
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

}
