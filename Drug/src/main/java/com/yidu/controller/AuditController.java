package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.service.AuditService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 审核表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/audit")
public class AuditController {
	
	@Resource
	AuditService service;
	
	/**
	 * 显示列表的方法
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		
		
		List<Audit> list = service.showList(audit,pageUtil);
		
		
		int rows=service.findCount(audit);
		
		
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	@RequestMapping("/auditById")
	@ResponseBody
	public Message auditById(String id) {
		Audit audit = new Audit();
		audit.setAudId(id);
		audit.setAudState("1");
		
		int rows=service.updateByPrimaryKeySelective(audit);
		Message message = new Message();
		if(rows!=0) {
			message.setStatus(1);
			message.setMsg("操作成功");
		}
		
		return message;
	}
	
	
	/**
	 * 显示列表的方法
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String, Object> showList(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		
		List<Audit> list = service.bushowList(audit,pageUtil);
		for (Audit audit2 : list) {
			audit2.setAudTimes(Tools.getDateStr(audit2.getAudTime()));
			if (audit2.getAudState().equals("0")) {
				audit2.setAuName("未审核");
			}else if(audit2.getAudState().equals("1")){
				audit2.setAuName("已审核");
			}else {
				audit2.setAuName("未通过");
			}
		}
		
		int rows=service.selectCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
}

