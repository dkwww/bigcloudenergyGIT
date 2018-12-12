package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.util.Message;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 销售明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/saleDetail")
public class SaleDetailController {
	
	
	/**
	 * 采购
	 * @param mes
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message add(String mes) {
		
		
		
		
		Message message = new Message();
		
		return message;
	}
}

