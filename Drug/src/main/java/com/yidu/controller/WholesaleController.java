package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.fabric.xmlrpc.base.Array;
import com.yidu.domain.Audit;
import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.AuditService;
import com.yidu.service.WholesaleDetailService;
import com.yidu.service.WholesaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店批发 前端控制器
 * </p>
 *
 * @author Likai
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/wholesale")
public class WholesaleController {
	@Resource
	private WholesaleService service;
	
	@Resource
	private WholesaleDetailService detaiwholesa;
	
	@Resource
	AuditService audits;
	
	/**
	 * 查询所有
	 * @param limit
	 * @param page
	 * @param record
	 * @return
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(@RequestParam(value = "limit",required = false)Integer limit,
			@RequestParam(value = "page" ,required = false)Integer page, Wholesale record){
		System.err.println("  sdsddddddddddddddddd"+limit+"==================="+page+"zxczxczxczxc="+record.getWholId());
		//分页工具对象
		PageUtil pages=new PageUtil();
		//判断分页的参数是否为空
		if(limit!=null && page!=null) {
			//页数赋值
			pages.setCurPage(page);
			//行数赋值
			pages.setRows(limit);
		}
		//创建map对象
		Map<String, Object> maps=new HashMap<String,Object >();
		//赋值查询ID
		maps.put("title",record.getWholId());
		//赋值开始的行数
		maps.put("kshs", pages.getStartRows());
		//赋值结束的行数
		maps.put("jshs", pages.getRows());
		
		//创建一个新的集合
		List<Wholesale> lists=new ArrayList<>();
		//根据map查询所有
 		List<Wholesale> list = service.selectAll(maps);
 		//查出总数
 		int selectCount = service.selectCount(maps);
 		System.err.println("   总行数的:"+selectCount);
 		//循环所有
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Wholesale wholesale = (Wholesale) iterator.next();
			//调用时间转换工具
			TimeUtil.dateToString(wholesale.getOptime(), "yyyy-MM-dd");
			//赋值给新集合
			lists.add(wholesale);
		}
		@SuppressWarnings("unchecked")
		//创建map集合
		Map<String,Object> map = new HashedMap();
		//设置code为0
		map.put("code", 0);
		//设置显示为空
		map.put("msg", "");
		//赋值查出总行数
		map.put("count", selectCount);
		//赋值查出的所有内容
		map.put("data", lists);
		
		//返回map
		return map;
	}
	
	/**
	 * 修改是否有效
	 * @param wholesale
	 * @return
	 */
	@RequestMapping("/updateisva")
	@ResponseBody
	public int updateisva(Wholesale wholesale){
		//调用修改是否有效的方法
		return service.updateisva(wholesale);
	}	
	
	/**
	 * 增加或者修改
	 * @param record
	 * @return mes
	 */
	@RequestMapping("/addorupdate")
	@ResponseBody
	public Message addorupdate(@RequestBody Wholesale record) {
		int rows = service.addOrUpdate(record);
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
	 * 批发添加
	 * @param htmlstr
	 * @param zongshu
	 * @param zongjin
	 * @return
	 */
	@RequestMapping("/Wholesalemanagement")
	@ResponseBody
	public Message Wholesalemanagement(String htmlstr,int zongshu,String zongjin) {
		//创建订单对象
		Wholesale wholesale=new Wholesale();
		System.err.println("asdasdasdasd="+htmlstr);
		
		//设置一个int
		int num=0;
		//设置一个double
		double zong = 0;
		
		//将传来的字符用井号分割
		String[] sp=htmlstr.split("#");
		//拆分后循环
		for (int i = 0; i < sp.length; i++) {
			//根据逗号分割
			String[] pistr=sp[i].split(",");
			System.err.println("药品ID:"+pistr[0]);
			//拆分数组0为药品ID
			String drugid=pistr[0];
			System.err.println("药品名称:"+pistr[1]);
			//拆分数组1为药品名称
			String drugname=pistr[1];
			System.err.println("药品类型:"+pistr[2]);
			//拆分数组2为药品类型
			String drugtype=pistr[2];
			System.err.println("药品价格:"+pistr[3]);
			//拆分数组3为药品价格
			String drugmoney=pistr[3];
			System.err.println("药品数量:"+pistr[8]);
			//拆分数组8为药品数量
			int amount=Integer.parseInt(pistr[8]);
			System.err.println("药品小计:"+pistr[5]);
			//拆分数组5为药品小计
			String price=pistr[5];
			System.err.println("批发价:"+pistr[6]);
			//拆分数组6为批发价
			String drugpi=pistr[6];
			
			//创建一个随机数
			String uuid=UUID.randomUUID().toString().replace("-","");
			
			//只循环一次
			if(i==0) {
				//批发ID
				wholesale.setWholId(uuid);
				//店铺ID
				wholesale.setComId("1");
				//总数量
				wholesale.setWholAmount(zongshu);
				//总价
				wholesale.setWholPrice(Double.valueOf(zongjin));
				//操作日期
				wholesale.setOptime(new Date());
				//是否有效
				wholesale.setIsva("1");
				//操作人
				wholesale.setOper("蛇皮");
				
				//调用增加批发表的方法
				int wholes=service.insertSelective(wholesale);
				//判断是否成功
				if(wholes>0) {
					System.out.println("成功");
					num++;
				}else {
					System.out.println("失败");
					num=0;
				}
			}
			//创建批发明细的对象
			WholesaleDetail wholesaleDetail=new WholesaleDetail();
			//批发外键
			wholesaleDetail.setWholId(wholesale.getWholId());
			//药品编号
			wholesaleDetail.setDrugId(drugid);
			//药品数量
			wholesaleDetail.setWdAmount(amount);
			//药品单价
			wholesaleDetail.setWdPrice(drugmoney);
			//小计
			wholesaleDetail.setWdTotal(price);
			//是否有效
			wholesaleDetail.setIsva("1");
			//操作时间
			wholesaleDetail.setOptime(new Date());
			//操作人
			wholesaleDetail.setOper("蛇皮");
			
			//计算总金额
			zong=Double.valueOf(zong)+Double.valueOf(price);
			
			//调用增加明细的方法
			int detai=detaiwholesa.insertSelective(wholesaleDetail);
			//判断是否成功
			if(detai>0) {
				System.out.println("明细成功");
				num++;
			}else {
				System.out.println("明细失败");
				num=0;
			}
		}
		System.out.println(zong);
		
		//创建一个随机数
		String uuids=UUID.randomUUID().toString().replace("-","");
		//创建审核对象
		Audit audit=new Audit();
		//赋值业务ID
		audit.setAudFkId(wholesale.getWholId());
		//赋值总经理未审核数字
		audit.setAudState("28");
		//赋值总数
		audit.setWholAmount(zongshu);
		//赋值总价
		audit.setWholPrice(Double.valueOf(zongjin));
		//调用增加审核表的方法
		int audis=audits.addOrUpdate(audit);
		//判断是否成功
		if(audis>0) {
			System.out.println("添加审核成功");
		}else {
			System.out.println("添加审核失败");
		}
		
		//创建mes方法
		Message mes = new Message();
		//判断上述方法是否通过
		if(num>=2) {
			mes.setMsg("1");
		}else {
			mes.setMsg("2");
		}
		
		//返回mes
		return mes;
	}
}

