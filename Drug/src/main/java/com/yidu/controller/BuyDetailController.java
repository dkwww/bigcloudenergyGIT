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
import com.yidu.service.SaleService;
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
	 * 采购
	 * @param mes
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message add(String mes) {
		
		int buyRows = service.purchase(mes);
		
		
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

