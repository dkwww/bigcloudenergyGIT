package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.service.BuyHeDetailService;
import com.yidu.service.BuyHeService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

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
	
	@Resource
	private BuyHeService service;
	
	@Resource
	private BuyHeDetailService detaservice;
	
	
	/**
	 * 显示列表
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Buy buy,Integer page,Integer limit) {
		PageUtil pageUtil = new PageUtil();
		if(page!=null && limit!=null) {
			pageUtil.setCurPage(page);
			pageUtil.setRows(limit);
		}
		
		List<Buy> list = service.showList(buy,pageUtil);
		int rows=service.selectCount(buy);
		
		Map<String, Object> m = new HashMap<>();
		m.put("code", 0);
		m.put("msg", "");
		m.put("count", rows);
		m.put("data", list);
		return m;
	}
	
	/**
	 * 增加
	 * @param shuju 前台封装的明细数据
	 * @param sumNumber	前台传过来的总数量
	 * @param sumPrice	前台传过来的总价格
	 * @param Supplier	前台传过来的供应商
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Message add(String id,String shuju,String sumNumber,String sumPrice,String Supplier) {
		//创建采购订单对象
		Buy buy=new Buy();
		//创建采购明细对象
		BuyDetail detail = new BuyDetail();
		
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
		//存进总金额
		BigDecimal buyMoney = new BigDecimal(sumPrice);
		buy.setBuyMoney(buyMoney);
		buy.setBuyType("0");
		
		//放入dao
		service.addorUpdate(buy);
		
		
		//循环明细数据的数据
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
			
			detail.setBdetFkId(buyId);
			BigDecimal bdetPrices = new BigDecimal(bdetPrice);
			detail.setBdetPrice(bdetPrices);
			detail.setBdetAmount(Integer.valueOf(bdetAmount));
			BigDecimal bdetTotals = new BigDecimal(bdetTotal);
			detail.setBdetTotal(bdetTotals);
			detail.setBuyId(buy.getBuyId());
			
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
}

