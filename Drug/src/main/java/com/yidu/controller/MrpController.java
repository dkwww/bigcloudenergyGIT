package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Mrp;
import com.yidu.service.MrpService; 
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 制造计划 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/mrp")
public class MrpController {
	//制造计划service
	@Resource
	private  MrpService   mrpService ;



	/**
	 * 查询所有的方法
	 * @param mrp
	 * @return
	 * @author Pngjiangping
	 * @date：2019年1月9日 
	 * @return  map  layui前台格式
	 */
	@RequestMapping("qureyAll")
	@ResponseBody
	public  Map<String, Object>  qureyAll(Mrp  mrp ,Integer page,Integer limit ){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		//查询分页
		List<Mrp> list = mrpService.qureyAll(mrp,pageUtil);
		//遍历集合
		for (Mrp mrp2 : list) {
			//判断是否提交质检  将中文值返回到前台
			if (mrp2.getMrpPud()==0) {
				
				mrp2.setMrpPudName("未提交质检");
			}else {
				mrp2.setMrpPudName("已提交质检");
				
			}
			//将去到值加上百分比
			mrp2.setMrpRateName(mrp2.getMrpRate()+"%");
		}
		//查询行数
		int rows = mrpService.selectCountBySelectiv(mrp); 
		//layui前台格式
		Map<String, Object>  map  = new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	} 
}
