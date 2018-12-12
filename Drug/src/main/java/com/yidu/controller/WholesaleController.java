package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.fabric.xmlrpc.base.Array;
import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.domain.WholesaleDetail;
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
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/wholesale")
public class WholesaleController {
	@Resource
	private WholesaleService service;
	
	@Resource
	private WholesaleDetailService detaiwholesa;
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(@RequestParam(value = "limit",required = false)Integer limit,
			@RequestParam(value = "page" ,required = false)Integer page, Wholesale record){
		System.err.println("  sdsddddddddddddddddd"+limit+"==================="+page+"zxczxczxczxc="+record.getWholId());
		PageUtil pages=new PageUtil();
		if(limit!=null && page!=null) {
			pages.setCurPage(page);
			pages.setRows(limit);
		}
		Map<String, Object> maps=new HashMap<String,Object >();
		maps.put("title",record.getWholId());
		maps.put("kshs", pages.getStartRows());
		maps.put("jshs", pages.getRows());
		
		List<Wholesale> lists=new ArrayList<>();
 		List<Wholesale> list = service.selectAll(maps);
 		int selectCount = service.selectCount(maps);
 		System.err.println("   总行数的:"+selectCount);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Wholesale wholesale = (Wholesale) iterator.next();
			TimeUtil.dateToString(wholesale.getOptime(), "yyyy-MM-dd");
			lists.add(wholesale);
		}
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", selectCount);
		map.put("data", lists);
		return map;
	}
	
	@RequestMapping("/updateisva")
	@ResponseBody
	public int updateisva(Wholesale wholesale){
		return service.updateisva(wholesale);
	}	
	
	/**
	 * 增加或修改
	 * @return Message json信息类
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
	 * @return
	 */
	@RequestMapping("/Wholesalemanagement")
	@ResponseBody
	public Message Wholesalemanagement(String htmlstr,int zongshu,String zongjin) {
	
		//创建订单对象
		Wholesale wholesale=new Wholesale();
		System.err.println("asdasdasdasd="+htmlstr);
		
		int num=0;
		double zong = 0;
		
		String[] sp=htmlstr.split("#");
		for (int i = 0; i < sp.length; i++) {
			String[] pistr=sp[i].split(",");
			System.err.println("药品ID:"+pistr[0]);
			String drugid=pistr[0];
			System.err.println("药品名称:"+pistr[1]);
			String drugname=pistr[1];
			System.err.println("药品类型:"+pistr[2]);
			String drugtype=pistr[2];
			System.err.println("药品价格:"+pistr[3]);
			String drugmoney=pistr[3];
			System.err.println("药品数量:"+pistr[8]);
			int amount=Integer.parseInt(pistr[8]);
			System.err.println("药品小计:"+pistr[5]);
			String price=pistr[5];
			System.err.println("批发价:"+pistr[6]);
			String drugpi=pistr[6];
			
			String uuid=UUID.randomUUID().toString().replace("-","");
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
				int wholes=service.insertSelective(wholesale);
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
			
			zong=Double.valueOf(zong)+Double.valueOf(price);
			
			int detai=detaiwholesa.insertSelective(wholesaleDetail);
			if(detai>0) {
				System.out.println("明细成功");
				num++;
			}else {
				System.out.println("明细失败");
				num=0;
			}
		}
		System.out.println(zong);
		
		Message mes = new Message();
		if(num>=2) {
			mes.setMsg("1");
		}else {
			mes.setMsg("2");
		}
		return mes;
	}
}

