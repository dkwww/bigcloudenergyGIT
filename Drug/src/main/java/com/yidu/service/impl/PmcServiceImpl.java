package com.yidu.service.impl;

 
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.MrpMapper;
import com.yidu.dao.PmcMapper;
import com.yidu.domain.Mrp;
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
	@Resource
	private MrpMapper mrpMapper;

	@Override
	public List<Pmc> findAll(Pmc record, PageUtil pageUtil) {
		try {
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				record.setStartTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
			if (record.getStrEndTime()!=null&&!"".equals(record.getStrEndTime())) {
				record.setStartTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<Pmc> list = pmcMapper.selectBySelective(map);
		List<Pmc> newList = new ArrayList<Pmc>();
		for (Pmc pmc : list) {
			pmc.setStrStartTime(TimeUtil.dateToString(pmc.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			pmc.setStrEndTime(TimeUtil.dateToString(pmc.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
			String str = pmcMapper.isCheck(pmc.getPmcId());
			if (str!=null && !"".equals(str)) {
				pmc.setAudState(str);
			} else {
				pmc.setAudState("-1");
			}
			newList.add(pmc);
		}
		return newList;
	}

	@Override
	public int findCount(Pmc record) {
		return pmcMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(Pmc record) {
		try {
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				record.setPmcStart(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setPmcEnd(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		record.setOptime(new Date());
		if (record.getPmcId()!=null&&!"".equals(record.getPmcId())) {
			return pmcMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setPmcAmount(0);
			record.setPmcState("-1");
			record.setIsva("1");
			return pmcMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		return pmcMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	@Override
	public int check(String pmcId) {
		return pmcMapper.check(pmcId);
	}

	@Override
	public Pmc selectById(String pmcId) {
		 
		return pmcMapper.selectById(pmcId) ;
	}

	@Override
	public List<Pmc> showAudit(Pmc record, PageUtil pageUtil) {
		try {
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				record.setStartTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
			if (record.getStrEndTime()!=null&&!"".equals(record.getStrEndTime())) {
				record.setStartTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<Pmc> list = pmcMapper.selectByAudit(map);
		List<Pmc> newList = new ArrayList<Pmc>();
		for (Pmc pmc : list) {
			pmc.setStrStartTime(TimeUtil.dateToString(pmc.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			pmc.setStrEndTime(TimeUtil.dateToString(pmc.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
			newList.add(pmc);
		}
		return newList;
	}

	@Override
	public int findAuditCount(Pmc record) {
		return pmcMapper.selectAuditCount(record);
	}

	@Override
	public int addPmc(Pmc record) {
		return pmcMapper.addpmc(record);
	}

	@Override
	public int joinMade(Pmc record) {
		Pmc pmc = pmcMapper.selectByAuditId(record.getAudId());
		Mrp mrp = new Mrp();
		mrp.setMrpId(UUID.randomUUID().toString().replace("-", ""));
		mrp.setPmcId(pmc.getPmcId());
		mrp.setComName(pmc.getComName());
		mrp.setMrpOptime(pmc.getPmcStart());
		mrp.setMrpEndtime(pmc.getPmcEnd());
		mrp.setMrpPlan(pmc.getPmcAmount());
		mrp.setMrpIdea(0);
		mrp.setMrpRate("0");
		mrp.setMrpState(0);
		mrp.setMrpPud(0);
		mrp.setIsva("1");
		mrp.setOptime(new Date());
		return mrpMapper.insert(mrp);
	}

}
