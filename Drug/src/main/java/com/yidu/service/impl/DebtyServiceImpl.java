package com.yidu.service.impl;

 

import com.yidu.dao.DebtyMapper;
import com.yidu.domain.Debty;

import com.yidu.service.DebtyService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 财务表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DebtyServiceImpl   implements DebtyService {
	
	@Resource
	private DebtyMapper debtyMapper;
	/**
	 * 审核的查询
	 */
	@Override
	public List<Debty> findAll(Debty debty, PageUtil pageUtil) {
		//创建map
		Map<String, Object> map = new HashMap<String, Object>();
		//map赋值
		map.put("debty", debty);
		//map赋值
		map.put("pageUtil", pageUtil);
		//list集合
		List<Debty> selectAll = debtyMapper.selectAll(map);
		//创建list
		List<Debty> ss=new ArrayList<>(); 
		
		for (Debty Debty2 : selectAll) {
			//调用工具类，装换时间格式
			Debty2.setStrTime(Tools.getTimeStr(Debty2.getOptime()));
			//加入集合
			ss.add(Debty2);
		}	
		return ss;
	}
	/**
	 * 查询总共多少条数据
	 */
	@Override
	public int selectCount(Debty debty) {
		
		return debtyMapper.selectCount(debty);
	}
	
	/**
	 * 增加和修改的方法
	 */
	@Override
	public int addOrUpdate(Debty det) {
		//定义一个rows
		int rows=0;
		//判断id不等于空就是修改否则就是增加
		if (det.getDebId()!=null&&!"".equals(det.getDebId())) {
			//调用修改的方法
			rows=updateByPrimaryKeySelective(det);
		}else {
			//uuid
			String  uuid=UUID.randomUUID().toString().replaceAll("-", "");
			//增加uuid
			det.setDebId(uuid);
			//默认增加当前时间
			det.setOptime(new Date());
			//默认为0
			det.setIsva("0");
			//默认增加一个排序
			det.setSort(TimeUtil.getStrDate());
			//调用增加的方法
			rows=insertSelective(det);
		}
		return rows;
	}
	/**
	 * 批量修改
	 */
	@Override
	public int debtyUpdate(List<String> ids) {
		
		return debtyMapper.DebtyDeleteByPrimaryKeySelective(ids);
	}
	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(Debty record) {
		
		return debtyMapper.updateByPrimaryKey(record);
	}
	/**
	 * 增加
	 */
	@Override
	public int insertSelective(Debty record) {
		
		return debtyMapper.insertSelective(record);
	}
	@Override
	public int moneyupdate(Debty debty) {
		return debtyMapper.moneyupdate(debty);
	}

	/**
	 * 根据店铺id查询
	 */
	@Override
	public Debty findByComId(String id) {
		return debtyMapper.findByComId(id);
	}
	
	
	@Override
	public List<Debty> findcomIds(String comId) {
		
		return debtyMapper.findcomIds(comId);
	}
	
	@Override
	public int addbty(BigDecimal money,String debtyId) {
		return debtyMapper.updateMoney(money, debtyId);
	}
}
