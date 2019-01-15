package com.yidu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatType;
import com.yidu.service.MatTypeService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

/**
 * <p>
 * 原材料类型 前端控制器
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/matType")
public class MatTypeController {
	
	@Resource
	private MatTypeService matTypeService;
	
	/**
	 * 
	 * 方法说明：查询原材料所有
	 * @param material 原材料类型对象
	 * @param page	页数
	 * @param limit	行数
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(MatType type,Integer page,Integer limit){
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值页数
			pageUtil.setCurPage(page);
			//赋值行数
			pageUtil.setRows(limit);
		}
		
		//查询原材料类型集合
		List<MatType> list=matTypeService.showList(type,pageUtil);
		//循环类型集合
		for (MatType matType : list) {
			//转时间
			matType.setOptimes(Tools.getDateStr(matType.getOptime()));
		}
		//查询原材料行数
		int rows=matTypeService.selectCount(type);
		
		//创建map对象
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
		map.put("data", list);
		
		return map;
	}
	
	
	
	
	/**
	 * 
	 * 方法说明：增加或修改
	 * @param type 类型对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	@RequestMapping("addorupdate")
	@ResponseBody
	public Message addorupdate(@RequestBody MatType type) {
		//增加或修改到原材料类型数据库
		matTypeService.addorupdate(type);
		
		//调用mes工具类
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
	
	
}

