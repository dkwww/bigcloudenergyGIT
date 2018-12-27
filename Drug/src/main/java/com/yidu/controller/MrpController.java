package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Mrp;
import com.yidu.service.MrpService;
import com.yidu.util.Message;
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
	@Resource
	private  MrpService   mrpService ;



	/**
	 * 查询所有的方法
	 * @param mrp
	 * @return
	 */
	@RequestMapping("qureyAll")
	@ResponseBody
	public  Map<String, Object>  qureyAll(Mrp  mrp ,Integer page,Integer limit ){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		//查询并按照大小分页
		List<Mrp> list = mrpService.qureyAll(mrp,pageUtil);
		for (Mrp mrp2 : list) {
			if (mrp2.getMrpPud()==0) {
				mrp2.setMrpPudName("未提交质检");
			}else {
				mrp2.setMrpPudName("已提交质检");
				
			}
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
	@RequestMapping("add")
	@ResponseBody
	public   Message   add(Mrp  mrp) {
		Message  message =new Message();
		
		
		int rows = mrpService.insert(mrp);
		if (rows>0) {
			message.setStatus(1);
			message.setMsg("增加成功");
		}else {
			message.setStatus(0);
			message.setMsg("增加失败");
			
		}
		
		return  message;
	}
	
	

}

