package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.service.AuditService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
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
	 * @author zhengyouhong
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
	
	/**
	 * 审核的方法
	 * @param id
	 * @param state
	 * @return
	 */
	@RequestMapping("/auditById")
	@ResponseBody
	public Message auditById(String id,String state) {
		Audit audit = new Audit();
		audit.setAudId(id);
		audit.setAudState(state);
		
		int rows=service.updateByPrimaryKeySelective(audit);
		Message message = new Message();
		if(rows!=0) {
			message.setStatus(1);
			message.setMsg("操作成功");
			
			
		}
		
		return message;
	}
	
	@RequestMapping("/showBuy")
	@ResponseBody
	public Map<String, Object> showBuy(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.showBuy(audit,pageUtil);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	
	@RequestMapping("/showCEO")
	@ResponseBody
	public Map<String, Object> showCEO(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.showCEO(audit,pageUtil);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	/**
	 * 查询审核状态
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Audit findById(String audId) {
		return service.findById(audId);
	}
	
}

