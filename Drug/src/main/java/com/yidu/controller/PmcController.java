package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	
	/**
	 * 显示所有生产计划
	 * @param record 生产计划模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 生成计划
	 * @author ZhouJun
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Pmc record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询所有的物料清单数据
		List<Pmc> list = pmcService.findAll(record,pageUtil);
		//获得条件查询所有的物料清单数据的总行数
		int rows = pmcService.findCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param record 生成计划模型类
	 * @return mes json工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody Pmc record) {
		//增加或修改并获得修改的行数
		int rows = pmcService.addOrUpdate(record);
		//获得json信息工具类
		Message mes = new Message();
		//如果修改的行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("操作成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 批量删除
	 * @param ids id集合
	 * @return mes json信息工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/bulkUpdate")
	@ResponseBody
	public Message bulkUpdate(@RequestBody List<String> ids) {
		//进行批量删除并获得处理行数
		int rows = pmcService.bulkUpdate(ids);
		//json信息工具类
		Message mes = new Message();
		//如果处理的行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 检查生产计划信息是否完善
	 * @param comId 公司id
	 * @param pmcId 生产计划id
	 * @return mes json工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Message check(String comId,String pmcId) {
		//json信息工具类
		Message mes = new Message();
		//根据计划id查询查询物料明细并返回处理的行数
		int rows = pmcService.check(pmcId);
		//如果处理的行数大于零
		if (rows>0) {
			//获得审核模型类
			Audit audit = new Audit();
			//审核公司id赋值
			audit.setQcFkId(comId);
			//审核计划id赋值
			audit.setAudFkId(pmcId);
			//审核状态赋值 未审核
			audit.setAudState("10001");
			//增加或修改并返回处理的行数
			int count = auditService.addOrUpdate(audit);
			//如果处理的行数大于零
			if (count>0) {
				///赋值成功信息
				mes.setStatus(1);
				mes.setMsg("提交成功，待审核！");
			} else {
				//赋值失败信息
				mes.setStatus(0);
				mes.setMsg("数据异常请稍后重试！");
			}
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("请配置计划药品信息！");
		}
		return mes;
	}
	
	/**
	 * 显示审核列表
	 * @param record 生产计划模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 生产计划数据
	 * @author ZhouJun
	 */
	@RequestMapping("/showAudit")
	@ResponseBody
	public Map<String,Object> showAudit(Pmc record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询生产计划数据
		List<Pmc> list = pmcService.showAudit(record,pageUtil);
		//获得条件查询生产计划数据的总行数
		int rows = pmcService.findAuditCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 加入制造计划
	 * @param record 生产计划模型类
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	@RequestMapping("/joinMade")
	@ResponseBody
	public int joinMade(Pmc record) {
		//加入制造计划并返回处理的行数
		return pmcService.joinMade(record);
	}
}

