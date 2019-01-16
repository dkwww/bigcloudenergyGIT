package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatInv;
import com.yidu.domain.Material;
import com.yidu.service.MatInvService;
import com.yidu.service.MaterialService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 原材料 前端控制器
 * </p>
 *
 * @author dengkangwei
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/material")
public class MaterialController {
	@Resource
	private MaterialService matservice;
	
	
	@Resource
	private MatInvService matinvService;
	
	/**
	 * 
	 * 方法说明：查询原材料所有
	 * @param material 原材料对象
	 * @param page	页数
	 * @param limit	行数
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(Material material,Integer page,Integer limit){
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值页数
			pageUtil.setCurPage(page);
			//赋值行数
			pageUtil.setRows(limit);
		}
		
		//查询原材料集合
		List<Material> list=matservice.showList(material,pageUtil);
		//查询原材料行数
		int rows=matservice.selectCount(material);
		
		//创建map集合
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
		map.put("data", list);
		
		
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param mat 原材料对象
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("addorUpdate")
	@ResponseBody
	public Message addorUpdate(@RequestBody Material mat) {
		
		//增加或修改到原材料数据库
		matservice.addorUpdate(mat);
		
		//得到库存对象
		MatInv inv=new MatInv();
		//存入原材料id
		inv.setMatId(mat.getMatId());
		//放入库存数据库
		matinvService.add(inv);
		
		//调用mes工具类
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
		
	}
	
	
}

