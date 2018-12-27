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
	 * 查询所有
	 * @return
	 */
	@RequestMapping("showList")
	@ResponseBody
	public Map<String, Object> showList(MatType type,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<MatType> list=matTypeService.showList(type,pageUtil);
		for (MatType matType : list) {
			matType.setOptimes(Tools.getDateStr(matType.getOptime()));
		}
		int rows=matTypeService.selectCount(type);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",rows);
		map.put("data", list);
		
		return map;
	}
	
	
	
	
	/**
	 * 增加或修改
	 * @param type
	 * @return
	 */
	
	@RequestMapping("addorupdate")
	@ResponseBody
	public Message addorupdate(@RequestBody MatType type) {
		matTypeService.addorupdate(type);
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
	
	/**
	 * 根据id显示修改
	 * @param mtId
	 * @return
	 */
	public MatType showUpdate(String mtId) {
		
		return matTypeService.showUpdate(mtId);
	}
	
	
	/**
	 * 删除
	 * @param mtId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(String mtId) {
		matTypeService.delete(mtId);
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("删除成功");
		
		return me;
	}
	
	
	/**
	 *  批量删除
	 * @param ids 传入一个ids
	 * @return 返回mes
	 */
	@RequestMapping("/TypeUpdate")
	@ResponseBody
	public Message TypeUpdate(@RequestBody List<String> ids) {
		//调用批量修改的方法
		matTypeService.TypeupdateByPrimaryKeySelective(ids);
		//创建message
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("删除成功");
		return me;
	}
	
}

