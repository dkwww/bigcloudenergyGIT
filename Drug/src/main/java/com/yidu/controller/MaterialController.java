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
 * @author Pngjiangping
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
	 * 查询所有
	 * @param material
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(Material material,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		
		List<Material> list=matservice.showList(material,pageUtil);
		int rows=matservice.selectCount(material);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
		map.put("data", list);
		
		
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param mat
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
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
		
	}
	
	
}

