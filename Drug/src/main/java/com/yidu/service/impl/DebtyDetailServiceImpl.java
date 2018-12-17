package com.yidu.service.impl;

 
import com.yidu.dao.DebtyDetailMapper;
import com.yidu.domain.Debty;
import com.yidu.domain.DebtyDetail;
import com.yidu.service.DebtyDetailService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 财物明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DebtyDetailServiceImpl  implements DebtyDetailService {
	
	@Resource
	private DebtyDetailMapper debtyDetailMapper;
	/**
	 * 查询的方法
	 */
	@Override
	public List<DebtyDetail> findAll(DebtyDetail debty, PageUtil pageUtil, String debId) {
		//创建map
		Map<String, Object> map = new HashMap<String, Object>();
		//map赋值id 
		map.put("title", debId);
		//map赋值debty
		map.put("debty", debty);
		//map赋值pageUtil
		map.put("pageUtil", pageUtil);
		
		//list集合
		List<DebtyDetail> selectAll = debtyDetailMapper.selectAll(map);
		//创建list
		List<DebtyDetail> ss=new ArrayList<>(); 
		
		for (DebtyDetail Debty2 : selectAll) {
			//调用工具类，装换时间格式
			Debty2.setStrTime(Tools.getTimeStr(Debty2.getOptime()));
			//加入集合
			ss.add(Debty2);
		}	
		return ss;
	}
	/**
	 * 查询多少行
	 */
	@Override
	public int selectCount(DebtyDetail debty) {
		
		return debtyDetailMapper.selectCount(debty);
	}

	

}
