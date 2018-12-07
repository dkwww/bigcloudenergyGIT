package com.yidu.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyDetailService;
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
	
	
	/**
	 * 显示列表
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList() {
		List<BuyDetail> list = service.findAll();
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", 10);
		m.put("data", list);
		return m;
	}
	
	
	/**
	 * 采购
	 * @param mes
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message add(String mes) {
		
		int rows = 0;
		
		System.out.println(mes);
		String[] str = mes.split("&");
		for (int i = 0; i < str.length; i++) {
			BuyDetail detail = new BuyDetail();
			
			
			String[] strOne = str[i].split("#");
 			String drugName = strOne[0];//药品名称
			System.out.println("药品名称:"+drugName);
			String bdetPrice = strOne[2];//单价
			System.out.println("单价:"+bdetPrice);
			String drugUnit = strOne[3];//数量单位
			System.out.println("数量单位:"+drugUnit);
			String bdetTotal = strOne[5];//总价
			System.out.println("总价:"+bdetTotal);
			String bdetAmount = strOne[8];//数量
			System.out.println("数量:"+bdetAmount);
			String mess = strOne[9];//备注
			System.out.println("备注:"+mess);
			String bdetFkId = strOne[10];//药品id
			System.out.println("药品id:"+bdetFkId);
			
			detail.setBdetAmount(Integer.valueOf(bdetAmount));
			BigDecimal bdetPrices = new BigDecimal(bdetPrice);
			detail.setBdetPrice(bdetPrices);
			BigDecimal bdetTotals = new BigDecimal(bdetTotal);
			detail.setBdetTotal(bdetTotals);
			detail.setBdetFkId(bdetFkId);
			detail.setOptime(new Date());
			
			rows =service.addOrUpdate(detail);
		}
		
		Message message = new Message();
		if(rows!=0) {
			message.setMsg("操作成功");
			message.setStatus(1);
		}else {
			message.setMsg("操作失败");
			message.setStatus(0);
		}
		
		return message;
	}
	
}

