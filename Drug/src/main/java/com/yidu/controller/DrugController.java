package com.yidu.controller;


import java.util.List;
import java.util.Map;
    































import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Drug;
import com.yidu.service.AuditService;
import com.yidu.service.DrugService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.UploadUtil;

/**
 * <p>
 * 药品表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Resource
	private DrugService drugService;
	@Resource
	private AuditService auditService;
	
	/**
	 * 查询所有
	 * @return List<Drug> 药品集合
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Drug record,Integer page,Integer limit) {
		
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Drug> list = drugService.findAll(record, pageUtil);
		int rows = drugService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 上传文件
	 * @param req
	 * @return String 文件名
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		String fileName = UploadUtil.upload(req);
		Message mes = new Message();
		if (fileName!=null) {
			mes.setStatus(1);
			mes.setObj(fileName);
			mes.setMsg("上传成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("服务器错误，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 增加新药品
	 * @return Message json信息类
	 */
	@RequestMapping("/addDrug")
	@ResponseBody
	public Message addDrug(@RequestBody Drug record) {
		int rows = drugService.addOrUpdate(record);
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
		int rows = drugService.bulkUpdate(ids);
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
	 * 检查药品信息是否完善
	 * @param drugId 药品编号
	 * @return Message json工具类
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Message check(String drugId) {
		Message mes = new Message();
		int rows = drugService.check(drugId);
		if (rows>0) {
			Audit audit = new Audit();
			audit.setAudFkId(drugId);
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
			mes.setMsg("请完善药品信息！");
		}
		return mes;
	}
	
	/**
	 * 查询所有
	 * @return List<Drug> 药品集合
	 */
	@RequestMapping("/showLists")
	@ResponseBody
	public Map<String,Object> showLists(Drug record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Drug> list = drugService.selectBySelectives(record,pageUtil);
		int rows = drugService.findCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
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
	public Map<String,Object> showAudit(Drug record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Drug> list = drugService.showAudit(record,pageUtil);
		int rows = drugService.findAuditCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询所有
	 * @return List<Drug> 药品集合
	 */
	@RequestMapping("/showChecked")
	@ResponseBody
	public Map<String,Object> showChecked(Drug record,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Drug> list = drugService.findChecked(record,pageUtil);
		int rows = drugService.findCheckedCount(record);
		
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
}

