package com.yidu.service.impl;

 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yidu.dao.BuyDetailMapper;
import com.yidu.domain.Admin;
import com.yidu.domain.Audit;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Sale;
import com.yidu.domain.SaleDetail;
import com.yidu.service.AuditService;
import com.yidu.service.BuyDetailService;
import com.yidu.service.BuyService;
import com.yidu.service.DrugInvService;
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
	
	@Resource
	AuditService auditService;
	
	@Resource
	DrugInvService invService;

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
	public int purchase(String mes,Admin admin) {
		
		//总价
		String bdetAmount = "";
		String mess = "";
		
		//定义两个变量用于判断
		int buyRows = 0;
		
		
		String[] str = mes.split("&");
		//定义一个采购订单对象
		Buy buy = new Buy();
		//定义一个销售订单对象
		Sale sale = new Sale();
		//定义一个审核对象
		Audit audit = new Audit();
		//采购订单的id
		String uuidOne = UUID.randomUUID().toString().replaceAll("-", "");
		String uuidTwo = null;//用于存储销售单的id
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
			System.out.println("订单总数量:"+strOne[11]);
			BigDecimal money = new BigDecimal(strOne[12]);//订单总金额
			System.out.println("订单总数量:"+strOne[12]);
			String buyId = null;
			List<BuyDetail> buya = findById(strOne[strOne.length-1]);
			if(!buya.isEmpty()) {
				buyId = strOne[strOne.length-1];//订单id
				System.err.println("采购订单id "+strOne[strOne.length-1]);
				
			}
			
			
			DrugInve drugInv = invService.findDrug(bdetFkId);
			if(drugInv.getDiId()!=null&&!"".equals(drugInv.getDiId())) {
				System.out.println("找到了药品");
				
				if(buyId==null) {
					buy.setBuyId(uuidOne);//订单id
				}else {
					buy.setBuyId(buyId);//订单id
				}
				buy.setComId(admin.getComId());//店铺id
				buy.setBuyAmount(Integer.valueOf(amount));//总购买数量
				buy.setBuyMoney(money);//订单总价
				buy.setBuyTime(new Date());//采购时间
				buy.setBuyCompany("总店");//店铺
				buy.setBuyType("1");//采购类型   1为药品   0为药材
				buy.setBuyAudit("1");//采购类型   1为采购中
				buy.setBuyQc("0");
				buy.setBuyState("1");
				buy.setBuyPut("0");
				buy.setBuyMes(mess);
				buy.setIsva("有效");
				buy.setOptime(new Date());//操作时间
				buy.setOper(admin.getAdminName());//操作人
				buy.setSort(TimeUtil.getStrDate());//排序
				
				if(i==0) {

					System.err.println("第一次循环");
					
					if(buy.getBuyId().equals(uuidOne)) {

						System.err.println("   进来了增加的方法");
						//采购订单增加的方法
						buyService.insertSelective(buy);
					}else {
						mapper.deleteByPrimaryKeys(buyId);
						buyService.updateByPrimaryKeySelective(buy);
					}
					
					
					audit.setAudFkId(uuidOne);
					audit.setAudComtype("1");
					audit.setQcFkId(admin.getComId());
					audit.setAudTime(new Date());
					audit.setAudState("1");
					audit.setAudIdea("分公司增加库存");
					audit.setAudName(admin.getAdminName());
					audit.setAudMes(null);
					audit.setIsva("有效");
					audit.setOptime(new Date());
					audit.setOper(admin.getAdminName());
					audit.setSort(TimeUtil.getStrDate());
					auditService.addOrUpdate(audit);//审核
				}
				BigDecimal bdetPrices = new BigDecimal(bdetPrice);//单价
				BigDecimal bdetTotals = new BigDecimal(bdetTotal);//总价

				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				bDetail.setBdetId(uuid);
				bDetail.setBuyId(uuidOne);
				
				bDetail.setBdetAmount(Integer.valueOf(bdetAmount));
				bDetail.setBdetPrice(bdetPrices);
				bDetail.setBdetTotal(bdetTotals);
				bDetail.setBdetFkId(bdetFkId);
				bDetail.setIsva("有效");
				bDetail.setOper(admin.getAdminName());
				bDetail.setOptime(new Date());
				
				buyRows =insertSelective(bDetail);
				
				
				if(i==0) {
					
					//给销售单定义一个id
					uuidTwo = UUID.randomUUID().toString().replaceAll("-", "");
					System.out.println("uuid:"+uuidTwo);
					sale.setSaleId(uuidTwo);
					sale.setSaleTime(new Date());
					sale.setSaleAmount(Integer.valueOf(amount));
					sale.setSaleMoney(money);
					sale.setIsva("有效");
					sale.setOptime(new Date());
					sale.setOper(null);
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
				detail.setOper(null);
				
				saleDetailService.addOrUpdate(detail);
				
			
			}else {
				buyRows=0;
			}
			
			
		}
				
		return buyRows;
	}


	@Override
	public List<BuyDetail> findById(String id) {
		List<BuyDetail> list = mapper.findById(id);
		return list;
	}


	@Override
	public int updateByBuyId(BuyDetail detail) {
		return mapper.updateByBuyId(detail);
	}

}
