package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.MrpDetailsMapper;
import com.yidu.dao.PmcDetailsMapper;
import com.yidu.domain.MrpDetails;
import com.yidu.domain.PmcDetails;
import com.yidu.service.PmcDetailsService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

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
	private PmcDetailsMapper pmcDetailsMapper;//注入生产计划明细导类
	@Resource
	private MrpDetailsMapper mrpDetailMapper;//注入制造计划明细导类

	@Override
	public int addOrUpdate(PmcDetails record) {
		//操作时间赋值当前时间
		record.setOptime(new Date());
		//如果计划明细不为空
		if (record.getPdId()!=null && !"".equals(record.getPdId())) {
			//进行修改并放回处理的行数
			return pmcDetailsMapper.updateByPrimaryKeySelective(record);
		} else {
			//计划明细生产状态赋值
			record.setPdState("0");
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//计划明细赋值有效状态
			record.setIsva("1");
			//进行增加并返回处理的行数
			return pmcDetailsMapper.insertSelective(record);
		}
	}

	@Override
	public List<PmcDetails> findAll(PmcDetails record, PageUtil pageUtil) {
		//获得一个map对象并赋值
		Map<String , Object> map = new HashMap<>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询生产明细并返回
		return pmcDetailsMapper.selectBySelective(map);
	}
	
	@Override
	public int selectCountBySelective(PmcDetails pmcDetail) {
		//获得条件查询生产明细总行数并返回
		return  pmcDetailsMapper.selectCountBySelective(pmcDetail);
	}

	@Override
	public List<PmcDetails> findByPmc(PmcDetails record, PageUtil pageUtil, String mrpId) {
		//获得一个map对象并赋值
		Map<String , Object>  map  =new  HashMap<>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//通过生产计划查询生产明细
		List<PmcDetails> list =  pmcDetailsMapper.selectBySelective(map);
		//获得一个集合
		List<PmcDetails> lists = new ArrayList<PmcDetails>();
		//循环遍历
		for (PmcDetails pmcDetails : list) {
			//获得制造明细模型类
			MrpDetails records = new MrpDetails();
			//制造计划id赋值
			records.setMrpId(mrpId);
			//制造计划药品id赋值
			records.setDrugId(pmcDetails.getDrugId());
			//查询制造完成度
			Integer amount = mrpDetailMapper.findStatistics(records);
			//如果完成度不为空
			if (amount!=null) {
				//完成度赋值
				pmcDetails.setFinisded(amount);
			} else {
				//完成度赋值
				pmcDetails.setFinisded(0);
			}
			//添加到集合
			lists.add(pmcDetails);
		}
		//放回集合
		return lists;
	}

	@Override
	public List<PmcDetails> selectPmcId(String id) {
		//根据生产计划id查询明细
		return pmcDetailsMapper.selectPmcId(id);
	}

	@Override
	public List<PmcDetails> checkInv(String drugId) {
		//根据药品id查询原材料库存并返回
		return pmcDetailsMapper.selectMatInv(drugId);
	}

}
