package com.yidu.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.SaleDetail;
import com.yidu.service.SaleDetailService;

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
	
	@Resource
	SaleDetailService service;
	
	
	@RequestMapping("/findById")
	@ResponseBody
	public List<SaleDetail> findById(String id) {
		return service.findById(id);
	}
}

