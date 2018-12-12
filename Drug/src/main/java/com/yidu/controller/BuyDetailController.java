package com.yidu.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.service.SaleDetailService;
import com.yidu.util.Message;

/**
 * <p>
 * 采购明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/buyDetail")
public class BuyDetailController {
	
	@Resource
	BuyDetailService service;
	
	@Resource
	BuyService buyService;
	
	@Resource
	SaleDetailService saleDetailService;
	
	/**
	 * 采购
	 * @param mes
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message add(String mes) {

		//总价
		BigDecimal total = new BigDecimal(0);
		String bdetAmount = "";
		String mess = "";
		
		//定义两个变量用于判断
		int buyRows = 0;
		int detailRows = 0;
		
		System.out.println(mes);
		String[] str = mes.split("&");
		//定义一个采购订单对象
		Buy buy = new Buy();
		//定义一个销售订单对象
		Sale sale = new Sale();
		//定义一个销售订单详情的对象
		SaleDetail detail = new SaleDetail();
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println("uuid:"+uuid);
		
		for (int i = 0; i < str.length; i++) {
			BuyDetail bDetail = new BuyDetail();
			
			
			String[] strOne = str[i].split("#");
 			String drugName = strOne[0];//药品名称
			System.out.println("药品名称:"+drugName);
			String bdetPrice = strOne[2];//单价
			System.out.println("单价:"+bdetPrice);
			String drugUnit = strOne[3];//数量单位
			System.out.println("数量单位:"+drugUnit);
			String bdetTotal = strOne[5];//总价
			System.out.println("总价:"+bdetTotal);
			bdetAmount = strOne[8];//数量
			System.out.println("数量:"+bdetAmount);
			mess = strOne[9];//备注
			System.out.println("备注:"+mess);
			String bdetFkId = strOne[10];//药品id
			System.out.println("药品id:"+bdetFkId);
			String amount = strOne[11];//订单总数量
			BigDecimal money = new BigDecimal(strOne[12]);//订单总金额
			
			buy.setBuyId(uuid);
			buy.setComId("1");
			buy.setBuyAmount(Integer.valueOf(amount));
			buy.setBuyMoney(money);
			buy.setBuyTime(new Date());
			buy.setBuyCompany("总店");
			buy.setBuyType("1");
			buy.setBuyAudit("未审核");
			buy.setBuyQc("未质检");
			buy.setBuyState("0");
			buy.setBuyPut("未入库");
			buy.setBuyMes(mess);
			buy.setIsva("有效");
			buy.setOptime(new Date());
			buy.setOper("张三");
			
			if(i==0) {
				detailRows =buyService.insertSelective(buy);
			}
			
			bDetail.setBuyId(uuid);
			bDetail.setBdetAmount(Integer.valueOf(bdetAmount));
			BigDecimal bdetPrices = new BigDecimal(bdetPrice);
			bDetail.setBdetPrice(bdetPrices);
			BigDecimal bdetTotals = new BigDecimal(bdetTotal);
			total = total.add(bdetTotals);
			bDetail.setBdetTotal(bdetTotals);
			bDetail.setBdetFkId(bdetFkId);
			bDetail.setIsva("有效");
			bDetail.setOper("张三");
			bDetail.setOptime(new Date());
			
			
			buyRows =service.addOrUpdate(bDetail);
			
			if(buyRows!=0 && detailRows !=0 && i==str.length-1) {
				
			}
			
			
		}
		
		
		
		Message message = new Message();
		if(buyRows!=0) {
			message.setMsg("操作成功");
			message.setStatus(1);
		}else {
			message.setMsg("操作失败");
			message.setStatus(0);
		}
		
		return message;
	}
	
}

