package com.yidu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	private DrugService drugService;//注入药品业务类
	@Resource
	private AuditService auditService;//注入审核业务类
	
	/**
	 * 查询所有
	 * @param record 药品模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 药品数组
	 * @author ZhouJun
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Drug record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询药品数据
		List<Drug> list = drugService.findAll(record, pageUtil);
		//获得条件查询药品数据的总行数
		int rows = drugService.findCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 上传文件
	 * @param req 请求对象
	 * @return mes json信息工具类
	 * @throws Exception
	 * @author ZhouJun
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		//获得文件名
		String fileName = UploadUtil.upload(req);
		//获得json信息工具类
		Message mes = new Message();
		//如果名字不为空
		if (fileName!=null) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setObj(fileName);
			mes.setMsg("上传成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("服务器错误，请稍后重试！");
		}
		//返回json信息类
		return mes;
	}
	
	/**
	 * 增加或修改
	 * @param record 药品模型类
	 * @return mes json信息工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/addDrug")
	@ResponseBody
	public Message addDrug(@RequestBody Drug record) {
		//增加或修改并获得处理的行数
		int rows = drugService.addOrUpdate(record);
		//获得json信息工具类
		Message mes = new Message();
		//如果处理行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("操作成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		//返回json信息类
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
		//批量删除并返回处理的行数
		int rows = drugService.bulkUpdate(ids);
		//获得json信息工具类
		Message mes = new Message();
		//如果处理行数大于零
		if (rows>0) {
			//赋值成功信息
			mes.setStatus(1);
			mes.setMsg("删除成功");
		} else {
			//赋值失败信息
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		//返回json信息类
		return mes;
	}
	
	/**
	 * 检查药品信息是否完善
	 * @param comId 公司id
	 * @param drugId 药品id
	 * @return mes json工具类
	 * @author ZhouJun
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Message check(String comId,String drugId) {
		//获得json信息工具类
		Message mes = new Message();
		//检查药品信息是否完善并返回行数
		int rows = drugService.check(drugId);
		//如果行数大于零
		if (rows>0) {
			//获得审核模型
			Audit audit = new Audit();
			//审核公司id赋值
			audit.setQcFkId(comId);
			//审核业务编号赋值药品id
			audit.setAudFkId(drugId);
			//审核状态赋值
			audit.setAudState("10101");
			//增加或修改
			int count = auditService.addOrUpdate(audit);
			//如果修改的行数大于零
			if (count>0) {
				//赋值成功信息
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
			mes.setMsg("请完善药品信息！");
		}
		//返回json信息类
		return mes;
	}
	
	/**
	 * 显示审核列表
	 * @param record 药品模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 药品数组
	 * @author ZhouJun
	 */
	@RequestMapping("/showAudit")
	@ResponseBody
	public Map<String,Object> showAudit(Drug record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页的行数赋值
		pageUtil.setRows(limit);
		
		//条件查询药品数据
		List<Drug> list = drugService.showAudit(record,pageUtil);
		//获得条件查询药品数据的总行数
		int rows = drugService.findAuditCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 显示已经审核过的药品
	 * @param record 药品模型类
	 * @param page 页数
	 * @param limit 行数
	 * @return map 药品数组
	 * @author ZhouJun
	 */
	@RequestMapping("/showChecked")
	@ResponseBody
	public Map<String,Object> showChecked(Drug record,Integer page,Integer limit) {
		//获得分页工具类
		PageUtil pageUtil = new PageUtil();
		//开始页数赋值
		pageUtil.setCurPage(page);
		//每页行数赋值
		pageUtil.setRows(limit);
		
		//条件查询药品数据
		List<Drug> list = drugService.findChecked(record,pageUtil);
		//获得条件查询药品数据的总行数
		int rows = drugService.findCheckedCount(record);
		
		//获得一个map对象并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
}

