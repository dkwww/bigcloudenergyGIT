package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.service.BranchSaleDetailService;
import com.yidu.service.BranchSaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 分店销售 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/branchSale")
public class BranchSaleController {
	/**
	 * 注入销售单接口
	 */
	@Resource
	private BranchSaleService service;
	
	@Resource
	private BranchSaleDetailService detailService;
	/**
	 * 显示列表
	 * @param page
	 * @param limit
	 * @param sale
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(String page,String limit,BranchSale branchSale){
		PageUtil util=new PageUtil();
		util.setCurPage(Integer.valueOf(page));
		util.setRows(Integer.valueOf(limit));
		List<BranchSale> list=new ArrayList<>();
		List<BranchSale> lists=service.query(util,branchSale);
		int rows=service.findCount(branchSale);
		for (BranchSale branchSale2 : lists) {
			System.out.println(branchSale2.getComId());
			System.out.println(branchSale2.getMenId());
			branchSale2.setOptimeStr(Tools.getTimeStr(branchSale2.getOptime()));
			list.add(branchSale2);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		//总行数
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 增加
	 * @param htmlStr
	 * @return
	 */
	@RequestMapping("/addSale")
	@ResponseBody
	public Message addSale(String htmlStr) {
		

		//创建订单对象
		BranchSale branchSale=new BranchSale();
		System.err.println("asdasdasdasd="+htmlStr);
		
		int num=0;
		int zong = 0;
		
		String[] st=htmlStr.split("#");
		for (int i = 0; i < st.length; i++) {
			String[] ls=st[i].split(",");
			System.err.println("药品ID:"+ls[0]);
			String drugId=ls[0];
			System.err.println("药品名称:"+ls[1]);
			String drugName=ls[1];
			System.err.println("零售数量:"+ls[2]);
			int bsAmount=Integer.parseInt(ls[2]);
			System.err.println("零售价格:"+ls[3]);
			String bsMoney=ls[3];
			System.err.println("会员折扣率:"+ls[4]);
			String zl=ls[4];
			System.err.println("折扣单价:"+ls[5]);
			String zj=ls[5];
			System.err.println("折扣总金额:"+ls[6]);
			String ze=ls[6];
			
			String uuid=UUID.randomUUID().toString().replace("-","");
			if(i==0) {
				//零售ID
				branchSale.setBsId(uuid);
				//店铺ID
				branchSale.setComId("1");
				//会员ID
				branchSale.setMenId("1");
				//总数量
				branchSale.setBsAmount(bsAmount);
				//总价
				branchSale.setBsPrice(bsMoney);
				//操作日期
				branchSale.setOptime(new Date());
				//是否有效
				branchSale.setIsva("1");
				//操作人
				branchSale.setOper("傻逼");
				int wholes=service.insertSelective(branchSale);
				if(wholes>0) {
					System.out.println("成功");
					num++;
				}else {
					System.out.println("失败");
					num=0;
				}
			}
			//创建批发明细的对象
			BranchSaleDetail branchSaleDetail=new BranchSaleDetail();
			//零售外键
			branchSaleDetail.setBsId(branchSale.getBsId());
			//药品编号
			branchSaleDetail.setDrugId(drugId);
			//药品数量
			branchSaleDetail.setBsdAmount(bsAmount);
			//药品单价
			branchSaleDetail.setBsdPrice(bsMoney);
			//小计
			branchSaleDetail.setBsdTotal(bsMoney);
			//是否有效
			branchSaleDetail.setIsva("1");
			//操作时间
			branchSaleDetail.setOptime(new Date());
			//操作人
			branchSaleDetail.setOper("傻逼");
			
			zong=Integer.valueOf(zong)+Integer.valueOf(bsMoney);
			
			int detail=detailService.insertSelective(branchSaleDetail);
			if(detail>0) {
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