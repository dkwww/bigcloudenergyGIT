package com.yidu.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Company;
import com.yidu.domain.Debty;
import com.yidu.domain.DebtyDetail;
import com.yidu.service.AuditService;
import com.yidu.service.BuyHeDetailService;
import com.yidu.service.BuyHeService;
import com.yidu.service.CompanyService;
import com.yidu.service.DebtyDetailService;
import com.yidu.service.DebtyService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

/**
 * <p>
 * 采购订单 前端控制器
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/buyht")
public class BuyHeController {
	
	//采购订单service
	@Resource
	private BuyHeService service;
	
	//采购明细service
	@Resource
	private BuyHeDetailService detaservice;
	
	//审核service
	@Resource
	private AuditService audservice;
	
	//质检service
	@Resource
	private QcService qcservice;
	
	
	//店铺service
	@Resource
	private CompanyService comservice;
	
	//财务service
	@Resource
	private DebtyService debtyservice;
	
	//财务明细service
	@Resource
	private DebtyDetailService debtydetailservice;
	
	/**
	 * 显示列表
	 * @param buy 采购订单对象
	 * @param page 前台页数
	 * @param limit 前台行数
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Buy buy,Integer page,Integer limit) {
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			pageUtil.setCurPage(page);
			//赋值前台传来的行数
			pageUtil.setRows(limit);
		}
		
		//查询采购订单集合
		List<Buy> list = service.showList(buy,pageUtil);
		//循环采购订单内容
		for (Buy buytwo : list) {
			//转成时间格式
			buytwo.setBuyTimes(Tools.getDateStr(buytwo.getBuyTime()));
			 //审核状态判断如果是0就是未审核
			if (buytwo.getBuyAudit().equals("0")) {
				  buytwo.setAuName("未审核");
			}else if(buytwo.getBuyAudit().equals("1")){
				  buytwo.setAuName("已审核");
			}else {
				  buytwo.setAuName("未通过");
			}
			 
			//采购状态判断如果是0是"未采购",1是"已采购"
			if(buytwo.getBuyState().equals("0")) {
				buytwo.setBuyStates("未采购");
			}else if(buytwo.getBuyState().equals("1")) {
				buytwo.setBuyStates("已采购");
			}
			
			//提交状态判断如果是0是未提交,1是"已提交"
			if(buytwo.getBuySubmission().equals("0")) {
				buytwo.setBuySubmissions("未提交");
			}else {
				buytwo.setBuySubmissions("已提交");
			}
		}
		//总行数
		int rows=service.selectCount(buy);
		
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 采购材料增加、删除
	 * @param id		前台传来的id
	 * @param shuju     前台传来的数据
	 * @param sumNumber 总数量
	 * @param sumPrice	总价格
	 * @param Supplier	供应商
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Message add(String id,String shuju,String sumNumber,String sumPrice,String Supplier) {
		//创建采购订单对象
		Buy buy=new Buy();
		//创建采购明细对象
		BuyDetail detail = new BuyDetail();
		//创建审核对象
		Audit audit=new Audit();
		
		//根据前台传来的值用"#"分割
		String [] data=shuju.split("#");
		
		for (int i = 0; i < data.length; i++) {
			//删除明细
			detaservice.deleteDetail(id);
		}
		//删除订单
		service.delete(id);
		
		
		//存进供应商外键
		buy.setBuyCompany(Supplier);
		//存进总数量,是int类型必须强转下
		buy.setBuyAmount(Integer.valueOf(sumNumber));
		//存进总金额(因为是BigDecimal类型的,所以要强转下)
		BigDecimal buyMoney = new BigDecimal(sumPrice);
		buy.setBuyMoney(buyMoney);
		//状态为0是材料
		buy.setBuyType("0");
		//默认审核状态为0是未审核
		buy.setBuyAudit("0");
		//默认采购状态为0
		buy.setBuyState("0");
		//提交状态为0
		buy.setBuySubmission("0");
		//默认质检状态为0
		buy.setBuyQc("0");
		//默认入库状态为0
		buy.setBuyPut("0");
		//存入分店
		buy.setComId("0");
		
		//new获取当前时间
		Date date=new Date();
		//存进采购订单当前时间
		buy.setBuyTime(date);
		//放入数据库
		service.addorUpdate(buy);
		
		//把订单id放入审核外键
		audit.setAudFkId(buy.getBuyId());
		//默认审核状态为0
		audit.setAudState("0");
		//默认个公司id
		audit.setQcFkId("0");
		//存进审核
		audservice.add(audit);
		
		//循环采购明细数据的数据
		for (int i = 0; i < data.length; i++) {
			//循环数据里面的内容要以','分割
			String [] datas=data[i].split(",");
			String buyId=datas[0];
			System.out.println(" id"+buyId);
			String matName =datas[1];
			System.out.println(" 材料名"+matName);
			String bdetPrice=datas[2];
			System.out.println(" 单价"+bdetPrice);
			String bdetAmount=datas[3];
			System.out.println(" 数量"+bdetAmount);
			String bdetTotal=datas[4];
			System.out.println(" 小计"+bdetTotal);
			
			//把前台传来的id存入采购明细id
			detail.setBdetFkId(buyId);
			//把前台传来的单价存入采购明细单价(因为是BigDecimal类型的,所以要强转下)
			BigDecimal bdetPrices = new BigDecimal(bdetPrice);
			detail.setBdetPrice(bdetPrices);
			//把前台传来的数量存入采购明细数量,强转下,是int类型
			detail.setBdetAmount(Integer.valueOf(bdetAmount));
			//把前台传来的小计存入采购明细小计
			BigDecimal bdetTotals = new BigDecimal(bdetTotal);
			detail.setBdetTotal(bdetTotals);
			//把采购明细存入订单id
			detail.setBuyId(buy.getBuyId());
			
			//放入采购明细数据库
			detaservice.add(detail);
		}
		//获取message对象
		Message me=new Message();
		//是1的话
		me.setStatus(1);
		//操作成功
		me.setMsg("操作成功");

		return me;
	}
	
	
	
	
	/**
	 * 审核显示列表
	 * @param buy 采购订单对象
	 * @param page 前台的页数
	 * @param limit 前台的行数
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("AuditshowList")
	@ResponseBody
	public Map<String,Object> AuditshowList(Buy buy,Integer page,Integer limit){
		//得到分页对象
		PageUtil pageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			pageUtil.setCurPage(page);
			//赋值前台传来的行数
			pageUtil.setRows(limit);
		}
		
		//查询采购集合
		List<Buy> list = service.AuditshowList(buy,pageUtil);
		
		//循环采购所有
		for (Buy buytwo : list) {
			//转时间
			buytwo.setBuyTimes(Tools.getDateStr(buytwo.getBuyTime()));
			 //判断如果是0就是"未审核",1是 "已审核",最后是"未通过"
			 if (buytwo.getBuyAudit().equals("0")) {
				  buytwo.setAuName("未审核");
			}else if(buytwo.getBuyAudit().equals("1")){
				  buytwo.setAuName("已审核");
			}else {
				  buytwo.setAuName("未通过");
			}
			
		}
		//查询总行数
		int rows=service.AuditselectCount(buy);
		
		//创建map对象
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 
	 * 方法说明：删除订单
	 * @param buy
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Message delete(@RequestBody Buy buy) {
		//调用删除方法
		service.update(buy);
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("删除成功");
		return me;
	}
	
	
	/**
	 * 
	 * 方法说明：审核完后减财务
	 * @param buy 采购订单对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月9日
	 */
	@RequestMapping("update")
	@ResponseBody
	public Message update(@RequestBody Buy buy) {
		//根据订单的分店id查询财务
		Debty deb=debtyservice.findcwId(buy.getComId());
		
		System.err.println("------------财务总金额"+deb.getDebMoney());
		System.err.println("------------材料总价格"+buy.getBuyMoney());
		System.err.println("=============财务id"+deb.getDebId());
		//判断如果审核状态不等于空且为1的时候就减财务
		if(buy.getBuyAudit()!="" && buy.getBuyAudit().equals("1")) {
			//根据财务id修改金额
			debtyservice.addbty(buy.getBuyMoney(),deb.getDebId());
			
			//得到财务明细对象
			DebtyDetail debmx=new DebtyDetail();
			//赋值一个id(getDateOrderNo)
			debmx.setDdetId(Tools.getDateOrderNo());
			//赋值财务的id
			debmx.setDebId(deb.getDebId());
			//赋值订单的金额
			debmx.setDdetChange(buy.getBuyMoney());
			//默认是否有效为1
			debmx.setIsva("1");
			//赋值0为支出状态
			debmx.setDdettFkId("0");
			//当前的时间
			debmx.setOptime(new Date());
			//放入数据库
			debtydetailservice.addmx(debmx);
		}
		
		
		//获取审核表的对象
		Audit audit=new Audit();
		//获取采购订单id
		audit.setQcFkId(buy.getBuyId());
		//审核意见
		audit.setAudIdea(buy.getAudIdea());
		//审核状态
		audit.setAudState(buy.getBuyAudit());
		//审核的当前时间
		Date date=new Date();
		audit.setAudTime(date);
		//数据添加到审核
		audservice.add(audit);
		
		//调用修改审核状态的方法
		service.update(buy);
		
		//创建me对象
		Message me=new Message();
		//赋值为1
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
	/**
	 * 采购状态修改
	 * @param buy
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("cgUpdate")
	@ResponseBody
	public Message cgUpdate(@RequestBody Buy buy) {
		//调用采购状态的修改方法
		service.update(buy);
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
	
	/**
	 * 采购订单提交到质检
	 * @param buy
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("addQc")
	@ResponseBody
	public Message addQc(@RequestBody Buy buy) {
		//调用采购提交质检的方法
		qcservice.addQc(buy);
		//调用修改质检状态方法
		qcservice.update(buy);
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		return me;
	}
	
}

