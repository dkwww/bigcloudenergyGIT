package com.yidu.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.domain.Debty;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Qc;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.AuditService;
import com.yidu.service.BuyService;
import com.yidu.service.DebtyService;
import com.yidu.service.DrugInvService;
import com.yidu.service.QcService;
import com.yidu.service.WholesaleDetailService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

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
	
	//审核service
	@Resource
	AuditService service;
	
	@Resource
	WholesaleDetailService detaiservice;
	
	
	@Resource
	DrugInvService druginvservice;
	
	@Resource
	DebtyService debtyservice;
	
	@Resource
	DebtyService debtyService;
	
	@Resource
	BuyService buyService;
	
	//质检service
	@Resource
	QcService qcService;
	
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
					//debty.setDebMoney(zongjia);
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
	

	/**                       
	 * 审核的方法
	 * @param id
	 * @param state
	 * @author zhengyouhong
	 * @return
	 */
	@RequestMapping("/auditByaudId")
	@ResponseBody
	public Message auditById(@RequestBody Audit audits) {
		
		//用于页面上的判断
		Message message = new Message();
		
		//定义一个盒子
		BigDecimal money = new BigDecimal(0);
		
		Audit audit = new Audit();
		audit.setAudId(audits.getAudId());
		audit.setAudState(audits.getAudState());
		
		
		if("12".equals(audits.getAudState())) {
			//如果分店总经理审核通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//根据订单中的店铺id查找这个店铺的总余额
			Debty debty1 = debtyService.findByComId(buy.getComId());
			System.out.println(" 财务余额："+debty1.getDebMoney()+"     订单总金额"+buy.getBuyMoney());
			int a =debty1.getDebMoney().compareTo(buy.getBuyMoney());
			Debty debty2 = new Debty();//定义一个新的财务对象
			debty2.setDebId(debty1.getDebId());
			//如果店铺余额大于总金额,则
			if(a==1||a==0) {
				money = debty1.getDebMoney().subtract(debty1.getDebMoney());
				//将需要修改的数据传入新对象中
				debty2.setDebMoney(money);
				int count = debtyService.updateByPrimaryKeySelective(debty2);
				if(count!=0) {
					int rows=service.updateByPrimaryKeySelective(audit);
					
					if(rows!=0) {
						message.setStatus(1);
						message.setMsg("操作成功");
					}else {
						message.setStatus(0);
						message.setMsg("操作失败");
					}
				}else {
					message.setStatus(0);
					message.setMsg("操作失败");
				}
				
			}else if(a==-1) {
				message.setStatus(0);
				message.setMsg("本店余额不足");
			}
			
		}else if("16".equals(audits.getAudState())) {
			//如果总店总经理审核通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//根据订单中的店铺id查找这个店铺的总余额
			Debty debty1 = debtyService.findByComId(buy.getComId());
			System.out.println(" 财务余额："+debty1.getDebMoney()+" 订单总金额"+buy.getBuyMoney());
			//将两个金额相加
			money =debty1.getDebMoney().add(buy.getBuyMoney());
			Debty debty2 = new Debty();//定义一个新的财务对象
			debty2.setDebId(debty1.getDebId());
			debty2.setDebMoney(money);
			//修改总店总金额
			int count = debtyService.updateByPrimaryKeySelective(debty2);
			if(count!=0) {
				Qc qc = new Qc();
				qc.setPmcId(buy.getBuyId());//业务id
				qc.setQcAmount(buy.getBuyAmount());//质检总数
				qc.setQcConpany(buy.getBuyCompany());//质检厂家
				qc.setQcType(1);//质检类型为药品
				qc.setIsva("1");
				//质检
				//qcService.insertSelective(qc);
				//审核
				int rows=service.updateByPrimaryKeySelective(audit);
				
				if(rows!=0) {
					message.setStatus(1);
					message.setMsg("操作成功");
				}else {
					message.setStatus(0);
					message.setMsg("操作失败");
				}
			}
			
		}else {
			
			int rows=service.updateByPrimaryKeySelective(audit);
			
			if(rows!=0) {
				message.setStatus(1);
				message.setMsg("操作成功");
			}else {
				message.setStatus(0);
				message.setMsg("操作失败");
			}
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
	

	@RequestMapping("/findSale")
	@ResponseBody
	public Map<String, Object> findSale(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.findSale(audit,pageUtil);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	

	@RequestMapping("/findCEO")
	@ResponseBody
	public Map<String, Object> findCEO(Audit audit,Integer page,Integer limit){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Audit> list = service.findCEO(audit,pageUtil);
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
	
	
	/**
	 * 增加或修改
	 * @param audit
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Message addOrUpdate(@RequestBody Audit audit) {
		Message mes = new Message();
		int rows = service.addOrUpdate(audit);
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功！");
		} else {
			mes.setStatus(0);
			mes.setMsg("操作失败！");
		}
		return mes;
	}
	
	/**
	 * 根据业务编号查询
	 * @param audit
	 * @return
	 */
	@RequestMapping("/findByFk")
	@ResponseBody
	public Audit findByFk(String audFkId,String type) {
		return service.findByFk(audFkId,type);
	}
}

