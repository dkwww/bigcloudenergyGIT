package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Drug;
import com.yidu.domain.Wholesale;
import com.yidu.domain.WholesaleDetail;
import com.yidu.service.WholesaleDetailService;
import com.yidu.service.WholesaleService;
import com.yidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店批发明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/wholesaleDetail")
public class WholesaleDetailController {
	@Resource
	WholesaleDetailService detailService;
	
	
	@RequestMapping("insertAdd")
	public int insertAdd(WholesaleDetail wholesaleDetail) {
		return detailService.insertSelective(wholesaleDetail);
	}
}

