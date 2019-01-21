package com.yidu.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.dao.DebtyDetailMapper;
import com.yidu.domain.Admin;
import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Debty;
import com.yidu.domain.DebtyDetail;
import com.yidu.domain.Drug;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Qc;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.AuditService;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.service.DebtyDetailService;
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
	DebtyDetailService debtyDetailService;
	
	@Resource
	DrugInvService druginvservice;
	
	@Resource
	DebtyService debtyservice;
	
	@Resource
	DebtyService debtyService;
	
	@Resource
	BuyService buyService;
	
	@Resource
	BuyDetailService buyDetailService;
	
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
	 * 方法说明：
	 * @param audit 审核对象
	 * @param page	前台页数
	 * @param limit 前台行数
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月14日
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String, Object> showList(Audit audit,Integer page,Integer limit){
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			pageUtil.setCurPage(page);
			//赋值前台传来的行数
			pageUtil.setRows(limit);
		}
		
		
		//查询审核集合
		List<Audit> list = service.bushowList(audit,pageUtil);
		//循环集合内容
		for (Audit audit2 : list) {
			//转时间
			audit2.setAudTimes(Tools.getDateStr(audit2.getAudTime()));
			//审核状态判断如果是"0"是未审核, "1"是已审核,最后是未通过
			if (audit2.getAudState().equals("0")) {
				audit2.setAuName("未审核");
			}else if(audit2.getAudState().equals("1")){
				audit2.setAuName("已审核");
			}else {
				audit2.setAuName("未通过");
			}
		}
		
		//查询总行数
		int rows=service.selectCount(audit);
		
		//创建map集合
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
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
	public Message examine(@RequestBody Audit audit) {
		Message message = new Message();
		System.err.println(audit.getAudFkId());
		System.err.println(audit.getAudId());
		
		int rows=service.updateByPrimaryKeySelective(audit);
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
	 * @author likai
	 * @date：2019年1月15日
	 */
	@RequestMapping("/financeo")
	@ResponseBody
	public Map<String, Object> financeo(Audit audit,Integer page,Integer limit){
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数和行数不等于空
		if(page!=null && limit!=null) {
			//赋值页数
			pageUtil.setCurPage(page);
			//赋值行数
			pageUtil.setRows(limit);
		}
		
		//创建一个空的集合
		List<Audit> lists=new ArrayList<>();
		//得到根据审核和分页查询所有的方法
		List<Audit> list = service.financeo(audit,pageUtil);
		//得到查询总数的方法
		int rows=service.findCount(audit);
		
		//创建map对象
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		//返回map
		return m;
	}
	
	
	/**
	 * 批发总经理审核
	 * @param audit
	 * @param zongjia
	 * @param session
	 * @return
	 * @author likai
	 * @date：2019年1月15日
	 */
	@RequestMapping("/Finanexamine")
	@ResponseBody
	public Message Finanexamine(@RequestBody Audit audit,Double zongjia,HttpSession session) {
		//得到session
		Admin admin=(Admin) session.getAttribute("admin");
		
		//得到mes提示对象
		Message message = new Message();
//		System.err.println(audit.getAudFkId());
//		System.err.println(audit.getAudId());
//		System.out.println(audit.getZongjia()+" "+audit.getWholPrice());
		//创建两个空盒子
		int l=0;
		int p=0;
		
		//得到根据业务查询所有的方法
		List<WholesaleDetail> list=detaiservice.finanAll(audit.getAudFkId());
		//遍历
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			WholesaleDetail wholesaleDetail = (WholesaleDetail) iterator.next();
			//得到药品库存对象
			DrugInve druginv=new DrugInve();
			//赋值药品id
			druginv.setDrugId(wholesaleDetail.getDrugId());
			//赋值店铺Id
			druginv.setComId(wholesaleDetail.getComId());
			
//			System.err.println("asdasdasd="+druginv.getComId());
//			System.err.println("zxczxczxc="+druginv.getDrugId());
			
			//根据库存对象查询所有
			List<DrugInve> invlist=druginvservice.findselect(druginv);
			//遍历
			for (Iterator iterator2 = invlist.iterator(); iterator2.hasNext();) {
				DrugInve drugInve = (DrugInve) iterator2.next();
				//判断当前库存是否大于前台数据
				if(drugInve.getDiAmount()>=wholesaleDetail.getWdAmount()) {
					//赋值药品数量
					drugInve.setDiAmount(wholesaleDetail.getWdAmount());
					//调用药品库存得到根据更改总数量的方法
					druginvservice.amountupdate(drugInve);
					
					//得到财务对象
					Debty debty=new Debty();
					
					//赋值店铺id
					debty.setComId(admin.getComId());	
					
					//创建bigcm的对象赋值总金额
					BigDecimal zongjias = new BigDecimal(audit.getWholPrice());
					//赋值总金额
					debty.setDebMoney(zongjias);
					//得到根据审核对象更改总金额的方法
					int money=debtyservice.moneyupdate(debty);
					//判断更改金额的方法是否错误
					if(money>0) {
						l++;
					}
					System.err.println("修改库存成功");
					
					
					Debty debyts=debtyservice.findcwId(admin.getComId());
					//创建财务明细对象
					DebtyDetail debtyDetail=new DebtyDetail();
					//赋值财务明细编号
					debtyDetail.setDdetId(Tools.getDateOrderNo());
					//赋值财务id
					debtyDetail.setDebId(debyts.getDebId());
					//赋值总金额
					debtyDetail.setDdetChange(new BigDecimal(audit.getWholPrice()));
					
					debtyDetail.setDdettFkId("1");
					//赋值状态
					debtyDetail.setIsva("1");
					//赋值当前时间
					debtyDetail.setOptime(new Date());
					//得到添加到审核明细的方法
					int debtyok=debtyDetailService.insertSelective(debtyDetail);
					//判断方法是否成功
					if(debtyok>0) {
						System.err.println("成功经理审核出现明细");
					}
					//增加
					l++;
				}else {
					System.err.println("修改库存失败");
				}
			}
	}
		//判断盒子是否大于0
		if(l>0) {
			audit.setAudState("31");
			//得到修改状态的方法
			int rows=service.updateByPrimaryKeySelective(audit);
			//mes赋值状态
			message.setStatus(1);
			//mes赋值提示
			message.setMsg("操作成功");
		}
		//返回mes
		return message;
	}
	

	/**                       
	 * 审核的方法
	 * @param audits
	 * @author zhengyouhong
	 * @return
	 */
	@RequestMapping("/auditByaudId")
	@ResponseBody
	public Message auditById(@RequestBody Audit audits) {
		
		//用于页面上的判断
		Message message = new Message();
		
		Audit audit = new Audit();
		//审核id
		audit.setAudId(audits.getAudId());
		//审核状态
		audit.setAudState(audits.getAudState());
		
		if("12".equals(audits.getAudState())) {
			//如果分店总经理审核通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//根据订单中的店铺id查找这个店铺的总余额
			Debty debty1 = debtyService.findByComId(buy.getComId());
			//判断采购订单金额和本店余额的大小
			int a =debty1.getDebMoney().compareTo(buy.getBuyMoney());
			//如果店铺余额大于总金额,则
			if(a>0) {
				//修改采购状态
				buyService.updateAudit(audits.getAudState(), buy.getBuyId());
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				DebtyDetail detail = new DebtyDetail();
				
				//根据财务id修改财务余额
				int count = debtyService.addbty(buy.getBuyMoney(),debty1.getDebId());
				if(count!=0) {
					//财务详情的id
					detail.setDdetId(uuid);
					//财务id
					detail.setDebId(debty1.getDebId());
					//明细金额
					detail.setDdetChange(buy.getBuyMoney());
					//采购id
					detail.setDdettFkId(buy.getBuyId());
					detail.setIsva("1");
					detail.setOptime(new Date());
					//财务明细的增加
					debtyDetailService.insertSelective(detail);
					//审核
					int rows=service.updateByPrimaryKeySelective(audit);
					//如果审核成功
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
				
			}else if(a<=1) {
				message.setStatus(0);
				message.setMsg("本店余额不足");
			}
			
		}else if("16".equals(audits.getAudState())) {
			//如果总店总经理审核通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//根据订单中的店铺id查找这个店铺的总余额 
			Debty debty1 = debtyService.findByComId(buy.getComId());
			//修改总店总金额
			int count = debtyService.addMoney(buy.getBuyMoney(),"0");
			if(count!=0) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				DebtyDetail detail = new DebtyDetail();
				//财务详情的id
				detail.setDdetId(uuid);
				//财务id
				detail.setDebId(debty1.getDebId());
				//明细金额
				detail.setDdetChange(buy.getBuyMoney());
				//采购id
				detail.setDdettFkId(buy.getBuyId());
				detail.setIsva("1");
				detail.setOptime(new Date());
				//财务明细的增加
				debtyDetailService.insertSelective(detail);
				//修改采购状态
				buyService.updateAudit(audits.getAudState(), buy.getBuyId());
				//根据采购id查询采购明细
				List<BuyDetail> list = buyDetailService.findByBuyId(buy.getBuyId());
				for (BuyDetail buyDetail : list) {
					//根据采购明细id查询药品库存
					DrugInve drugInv = druginvservice.findById(buyDetail.getBdetFkId());
					if(drugInv.getDiId()!=null&&!"".equals(drugInv.getDiId())) {
						//修改总店库存
						druginvservice.minusAmounts(buyDetail.getBdetAmount(), drugInv.getDiId());
					}
				}
				//质检
				qcService.branchQualityAdd(buy);
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
			
		}else if("2".equals(audits.getAudState())||"14".equals(audits.getAudState())) {
			//如果审核不通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//审核
			int rows=service.updateByPrimaryKeySelective(audit);
			//修改状态
			buyService.updateAudit(audits.getAudState(), buy.getBuyId());
			if(rows!=0) {
				message.setStatus(1);
				message.setMsg("操作成功");
			}else {
				message.setStatus(0);
				message.setMsg("操作失败");
			}
			
		}else {
			
			//如果审核不通过，则根据id查询出
			Buy buy = buyService.findById(audits.getAudFkId());
			//修改分店总金额
			int count = debtyService.addMoney(buy.getBuyMoney(),buy.getComId());
			if(count!=0) {
				//修改采购状态
				buyService.updateAudit(audits.getAudState(), buy.getBuyId());
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
		}
		
		
		
		return message;
	}
	/**
	 * 分店财务审核的查询所有
	 * @param audit
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 */
	@RequestMapping("/showBuy")
	@ResponseBody
	public Map<String, Object> showBuy(Audit audit,Integer page,Integer limit,HttpSession session){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		//获取session
		Admin admin = (Admin) session.getAttribute("admin");
		//分店财务查询所有
		List<Audit> list = service.showBuy(audit,pageUtil,admin);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	/**
	 * 分店总经理采购的查询所有
	 * @param audit
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 */
	@RequestMapping("/showCEO")
	@ResponseBody
	public Map<String, Object> showCEO(Audit audit,Integer page,Integer limit,HttpSession session){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		//获取session
		Admin admin = (Admin) session.getAttribute("admin");
		//分店总经理的查询所有
		List<Audit> list = service.showCEO(audit,pageUtil,admin);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	

	/**
	 * 总店销售审核查询所有
	 * @param audit
	 * @param page
	 * @param limit
	 * @param session
	 * @return Map
	 */
	@RequestMapping("/findSale")
	@ResponseBody
	public Map<String, Object> findSale(Audit audit,Integer page,Integer limit,HttpSession session){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		//获取session
		Admin admin = (Admin) session.getAttribute("admin");
		//总店销售审核查询所有
		List<Audit> list = service.findSale(audit,pageUtil,admin);
		int rows=service.findCount(audit);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	

	/**
	 * 总店总经理审核查询所有
	 * @param audit
	 * @param page
	 * @param limit
	 * @param session
	 * @return Map
	 */
	@RequestMapping("/findCEO")
	@ResponseBody
	public Map<String, Object> findCEO(Audit audit,Integer page,Integer limit,HttpSession session){
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		//获取session
		Admin admin = (Admin) session.getAttribute("admin");
		//总店总经理查询所有
		List<Audit> list = service.findCEO(audit,pageUtil,admin);
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
	 * 方法说明：显示明细
	 * @param audFkId
	 * @param type
	 * @param page
	 * @param limit
	 * @return
	 * @author ZhouJun
	 * @date：2019年1月1日
	 */
	@RequestMapping("/showDetail")
	@ResponseBody
	public Map<String,Object> showDetail(String comId,String audFkId,String type,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		
		List<Audit> list = service.findDetail(comId,audFkId, type, pageUtil);
		int rows = service.findDetailCount(comId,audFkId, type);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
}

