package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.domain.Debty;
import com.yidu.domain.DrugInve;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.AuditService;
import com.yidu.service.DebtyService;
import com.yidu.service.DrugInvService;
import com.yidu.service.WholesaleDetailService;
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
	
	@Resource
	WholesaleDetailService detaiservice;
	
	@Resource
	DrugInvService druginvservice;
	
	@Resource
	DebtyService debtyservice;
	
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
	
	
	/**
	 * 批发总经理审核
	 * @param audit
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/wholeceo")
	@ResponseBody
	public Map<String, Object> wholeceo(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.wholeceo(audit,pageUtil);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	@RequestMapping("/examine")
	@ResponseBody
	public Message examine(Audit audit) {
		Message message = new Message();
		System.err.println(audit.getAudFkId());
		System.err.println(audit.getAudId());
		
		int rows=service.wholeceoupdate(audit.getAudId());
		if(rows!=0) {
			message.setStatus(1);
			message.setMsg("操作成功");
		}
		return message;
	}
	
	
	/**
	 * 批发财务审核
	 * @param audit
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/financeo")
	@ResponseBody
	public Map<String, Object> financeo(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.financeo(audit,pageUtil);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	
	@RequestMapping("/Finanexamine")
	@ResponseBody
	public Message Finanexamine(Audit audit,Double zongjia) {
		Message message = new Message();
		System.err.println(audit.getAudFkId());
		System.err.println(audit.getAudId());
		
		int l=0;
		
		List<WholesaleDetail> list=detaiservice.finanAll(audit.getAudFkId());
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			WholesaleDetail wholesaleDetail = (WholesaleDetail) iterator.next();
			DrugInve druginv=new DrugInve();
			
			druginv.setDrugId(wholesaleDetail.getDrugId());
			druginv.setComId(wholesaleDetail.getComId());
			
			System.err.println("asdasdasd="+druginv.getComId());
			System.err.println("zxczxczxc="+druginv.getDrugId());
			
			List<DrugInve> invlist=druginvservice.findselect(druginv);
			for (Iterator iterator2 = invlist.iterator(); iterator2.hasNext();) {
				DrugInve drugInve = (DrugInve) iterator2.next();
				System.err.println("总库存==="+drugInve.getDiAmount());
				
				if(drugInve.getDiAmount()>wholesaleDetail.getWdAmount()) {
					drugInve.setDiAmount(wholesaleDetail.getWdAmount());
					druginvservice.amountupdate(drugInve);
					Debty debty=new Debty();
					debty.setComId(druginv.getComId());
					debty.setDebMoney(zongjia);
					int money=debtyservice.moneyupdate(debty);
					if(money>0) {
						l=1;
					}
					System.err.println("修改库存成功");
					l=2;
				}else {
					System.err.println("修改库存失败");
				}
			}
	}
		if(l==2 || l==1) {
			int rows=service.finanupdate(audit.getAudId());
			message.setStatus(1);
			message.setMsg("操作成功");
		}
		return message;
	}
	
}

