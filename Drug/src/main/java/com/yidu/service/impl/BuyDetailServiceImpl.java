package com.yidu.service.impl;

 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyDetailMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.service.SaleDetailService;
import com.yidu.service.SaleService;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 采购明细 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BuyDetailServiceImpl  implements BuyDetailService {


	@Resource
	BuyDetailMapper mapper;
	
	@Resource
	BuyService buyService;
	
	@Resource
	SaleDetailService saleDetailService;
	
	@Resource
	SaleService saleService;

	@Override
	public int addOrUpdate(BuyDetail detail) {
		
		int rows = 0;
		if(detail.getBdetId()!=null &&!"".equals(detail.getBdetId())) {
			rows = updateByPrimaryKeySelective(detail);
		}else {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			detail.setBdetId(uuid);
			rows = insertSelective(detail);
		}
		
		return rows;
	}
	
	
	@Override
	public int updateByPrimaryKeySelective(BuyDetail detail) {
		return mapper.updateByPrimaryKeySelective(detail);
	}



	@Override
	public int insertSelective(BuyDetail detail) {
		return mapper.insertSelective(detail);
	}


	@Override
	public int purchase(String mes) {
		
		//总价
				String bdetAmount = "";
				String mess = "";
				
				//定义两个变量用于判断
				int buyRows = 0;
				
				System.out.println(mes);
				String[] str = mes.split("&");
				//定义一个采购订单对象
				Buy buy = new Buy();
				//定义一个销售订单对象
				Sale sale = new Sale();
				
				String uuidOne = UUID.randomUUID().toString().replaceAll("-", "");
				String uuidTwo = null;//销售单的id
				System.out.println("uuid:"+uuidOne);
				
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
					
					buy.setBuyId(uuidOne);
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
						buyService.insertSelective(buy);
					}
					
					bDetail.setBuyId(uuidOne);
					bDetail.setBdetAmount(Integer.valueOf(bdetAmount));
					BigDecimal bdetPrices = new BigDecimal(bdetPrice);
					bDetail.setBdetPrice(bdetPrices);
					BigDecimal bdetTotals = new BigDecimal(bdetTotal);
					bDetail.setBdetTotal(bdetTotals);
					bDetail.setBdetFkId(bdetFkId);
					bDetail.setIsva("有效");
					bDetail.setOper("张三");
					bDetail.setOptime(new Date());
					
					
					buyRows =addOrUpdate(bDetail);
					
					if(i==0) {
						
						//给销售单定义一个id
						uuidTwo = UUID.randomUUID().toString().replaceAll("-", "");
						System.out.println("uuid:"+uuidOne);
						sale.setSaleId(uuidTwo);
						sale.setSaleTime(new Date());
						sale.setSaleAmount(Integer.valueOf(amount));
						sale.setSaleMoney(money);
						sale.setIsva("有效");
						sale.setOptime(new Date());
						sale.setOper("张三");
						//调用销售单增加的方法
						saleService.insertSelective(sale);
						
					}
					//定义一个销售订单详情的对象
					SaleDetail detail = new SaleDetail();
					
					detail.setDrugId(bdetFkId);
					detail.setSaleId(uuidTwo);
					detail.setSdAmount(Integer.valueOf(bdetAmount));
					detail.setSdPrice(bdetPrices);
					detail.setSdTotal(bdetTotals);
					detail.setIsva("有效");
					detail.setOptime(new Date());
					detail.setOper("张三");
					
					saleDetailService.addOrUpdate(detail);
					
				}
				
		return buyRows;
	}

}
