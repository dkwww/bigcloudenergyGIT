package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.yidu.domain.BranchSaleDetail;
import com.yidu.service.BranchSaleDetailService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店销售明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSaleDetail")
public class BranchSaleDetailController {
	@Resource
	private BranchSaleDetailService service;
	
	@RequestMapping("insertAdd")
	public int inserAdd(BranchSaleDetail branchSaleDetail) {
		
		return  service.insertSelective(branchSaleDetail);
		
	}
}

