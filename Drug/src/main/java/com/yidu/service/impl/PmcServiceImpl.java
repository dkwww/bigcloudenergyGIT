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
	private PmcMapper pmcMapper;//注入生产计划导类
	@Resource
	private MrpMapper mrpMapper;//注入制造计划导类

	@Override
	public List<Pmc> findAll(Pmc record, PageUtil pageUtil) {
		//捕获异常
		try {
			//如果计划开始时间不为空
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				record.setStartTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
			//如果计划结束时间不为空
			if (record.getStrEndTime()!=null&&!"".equals(record.getStrEndTime())) {
				record.setStartTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询生产计划
		List<Pmc> list = pmcMapper.selectBySelective(map);
		//获得一个集合
		List<Pmc> newList = new ArrayList<Pmc>();
		//循环遍历
		for (Pmc pmc : list) {
			//开始时间转字符串
			pmc.setStrStartTime(TimeUtil.dateToString(pmc.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			//结束时间转字符串
			pmc.setStrEndTime(TimeUtil.dateToString(pmc.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
			//查询审核状态
			String str = pmcMapper.isCheck(pmc.getPmcId());
			//如果审核状态不为空
			if (str!=null && !"".equals(str)) {
				//审核状态赋值
				pmc.setAudState(str);
			} else {
				//审核状态赋值
				pmc.setAudState("-1");
			}
			//添加到新的集合
			newList.add(pmc);
		}
		//返回新的集合
		return newList;
	}

	@Override
	public int findCount(Pmc record) {
		//获得条件查询所有的总行数
		return pmcMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(Pmc record) {
		//捕获异常并处理
		try {
			//如果计划时间不为空
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				//计划开始时间赋值
				record.setPmcStart(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				//计划结束时间赋值
				record.setPmcEnd(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//操作时间赋值
		record.setOptime(new Date());
		//如果计划id不为空
		if (record.getPmcId()!=null&&!"".equals(record.getPmcId())) {
			//进行修改并返回行数
			return pmcMapper.updateByPrimaryKeySelective(record);
		} else {
			//计划数量赋值
			record.setPmcAmount(0);
			//计划状态赋值
			record.setPmcState("-1");
			//计划赋值有效
			record.setIsva("1");
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//进行增加并返回行数
			return pmcMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		//批量删除并返回修改的行数
		return pmcMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	@Override
	public int check(String pmcId) {
		//更具计划id查询计划明总行数并放回
		return pmcMapper.check(pmcId);
	}

	@Override
	public Pmc selectById(String pmcId) {
		 //根据生产计划id查询并返回
		return pmcMapper.selectById(pmcId) ;
	}

	@Override
	public List<Pmc> showAudit(Pmc record, PageUtil pageUtil) {
		//捕获异常并处理
		try {
			//如果计划开始时间不为空
			if (record.getStrStartTime()!=null&&!"".equals(record.getStrStartTime())) {
				record.setStartTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTime(TimeUtil.stringToDate(record.getStrStartTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
			//如果计划结束时间不为空
			if (record.getStrEndTime()!=null&&!"".equals(record.getStrEndTime())) {
				record.setStartTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[0],  "yyyy-MM-dd HH:mm:ss"));
				record.setEndTimes(TimeUtil.stringToDate(record.getStrEndTime().split("到")[1],  "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询审核表的数据
		List<Pmc> list = pmcMapper.selectByAudit(map);
		//循环遍历
		for (Pmc pmc : list) {
			//开始时间遍历
			pmc.setStrStartTime(TimeUtil.dateToString(pmc.getPmcStart(), "yyyy-MM-dd HH:mm:ss"));
			//结束时间遍历
			pmc.setStrEndTime(TimeUtil.dateToString(pmc.getPmcEnd(), "yyyy-MM-dd HH:mm:ss"));
		}
		//集合去重复
		for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).getPmcId().equals(list.get(i).getPmcId())) {
                    list.remove(j);
                }
            }
        }
		//返回集合
		return list;
	}

	@Override
	public int findAuditCount(Pmc record) {
		//获得条件查询审核表的总行数
		return pmcMapper.selectAuditCount(record);
	}

	@Override
	public int joinMade(Pmc record) {
		//根据审核id查询生产计划
		Pmc pmc = pmcMapper.selectByAuditId(record.getAudId());
		//获得制造计划模型类
		Mrp mrp = new Mrp();
		//制造计划id赋值uuid
		mrp.setMrpId(UUID.randomUUID().toString().replace("-", ""));
		//制造计划业务编号赋值
		mrp.setPmcId(pmc.getPmcId());
		//制造计划厂家名字赋值
		mrp.setComName(pmc.getComName());
		//制造计划操作时间赋值
		mrp.setMrpOptime(pmc.getPmcStart());
		//制造计划结束时间赋值
		mrp.setMrpEndtime(pmc.getPmcEnd());
		//制造计划数量赋值
		mrp.setMrpPlan(pmc.getPmcAmount());
		//制造计划方案赋值
		mrp.setMrpIdea(1);
		//制造计划完成率赋值
		mrp.setMrpRate("0");
		//制造计划质检状态赋值
		mrp.setMrpState(0);
		//制造计划入库状态赋值
		mrp.setMrpPud(0);
		//制造计划赋值有效
		mrp.setIsva("1");
		//制造计划操作时间赋值当前时间
		mrp.setOptime(new Date());
		//进行增加并赋值
		return mrpMapper.insert(mrp);
	}

}
