package com.yidu.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Pmc;
import com.yidu.service.AuditService;
import com.yidu.service.PmcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划单 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/pmc")
public class PmcController {

	@Resource
	private PmcService pmcService;
	@Resource
	private AuditService auditService;
	
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Pmc record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Pmc> list = pmcService.findAll(record,pageUtil);
		int rows = pmcService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody Pmc record) {
		int rows = pmcService.addOrUpdate(record);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		int rows = pmcService.bulkUpdate(ids);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 检查生产计划信息是否完善
	 * @param drugId
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Message check(String pmcId) {
		Message mes = new Message();
		int rows = pmcService.check(pmcId);
		if (rows>0) {
			Audit audit = new Audit();
			audit.setAudFkId(pmcId);
			audit.setAudState("10001");
			int count = auditService.addOrUpdate(audit);
			if (count>0) {
				mes.setStatus(1);
				mes.setMsg("提交成功，待审核！");
			} else {
				mes.setStatus(0);
				mes.setMsg("数据异常请稍后重试！");
			}
		} else {
			mes.setStatus(0);
			mes.setMsg("请配置计划药品信息！");
		}
		return mes;
	}
	
	/**
	 * 显示审核列表
	 * @param record
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/showAudit")
	@ResponseBody
	public Map<String,Object> showAudit(Pmc record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Pmc> list = pmcService.showAudit(record,pageUtil);
		int rows = pmcService.findAuditCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/joinMade")
	@ResponseBody
	public int joinMade(Pmc record) {
		return pmcService.joinMade(record);
	}
}

