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
			String bdetPrice = strOne[2];//单价
			String drugUnit = strOne[3];//数量单位
			String bdetTotal = strOne[5];//总价
			bdetAmount = strOne[8];//数量
			mess = strOne[9];//备注
			String bdetFkId = strOne[10];//药品id
			String amount = strOne[11];//订单总数量
			BigDecimal money = new BigDecimal(strOne[12]);//订单总金额
			//先定义一个为空的采购id
			String buyId = null;
			//根据在这个数组末尾的采购id查询采购明细
			List<BuyDetail> buya = findById(strOne[strOne.length-1]);
			//如果查询的结果不为空则给空的采购id赋值
			if(!buya.isEmpty()) {
				buyId = strOne[strOne.length-1];//订单id
				
			}
			//搜索药品库存
			DrugInve drugInv = invService.findById(bdetFkId);
			if(drugInv.getDiAmount()!=null&&drugInv.getDiAmount()>=Integer.valueOf(bdetAmount)) {
				
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
				buy.setBuyAudit("1");//审核   1为采购中
				buy.setBuyQc("0");//质检状态  默认0
				buy.setBuyState("1");//采购状态
				buy.setBuyPut("0");//入库状态
				buy.setBuyMes(mess);//采购备注
				buy.setIsva("有效");
				buy.setOptime(new Date());//操作时间
				buy.setOper(admin.getAdminName());//操作人
				buy.setSort(TimeUtil.getStrDate());//排序
				
				if(i==0) {
					//判断采购id是否等于uuid
					if(buy.getBuyId().equals(uuidOne)) {
						//采购订单增加的方法
						buyService.insertSelective(buy);
						//审核的采购外键
						audit.setAudFkId(uuidOne);
					}else {
						//根据id删除
						mapper.deleteByPrimaryKeys(buyId);
						//修改
						buyService.updateByPrimaryKeySelective(buy);
						//审核的采购外键
						audit.setAudFkId(buyId);
					}
					
					audit.setAudComtype("1");//公司类型
					audit.setQcFkId(admin.getComId());//公司id
					audit.setAudTime(new Date());//审核时间
					audit.setAudState("1");//审核状态
					audit.setAudIdea("分公司增加库存");//审核意见
					audit.setAudName(admin.getAdminName());//审核人
					audit.setAudMes(null);//审核
					audit.setIsva("有效");
					audit.setOptime(new Date());
					audit.setOper(admin.getAdminName());
					audit.setSort(TimeUtil.getStrDate());
					auditService.addOrUpdate(audit);//审核
				}
				BigDecimal bdetPrices = new BigDecimal(bdetPrice);//单价
				BigDecimal bdetTotals = new BigDecimal(bdetTotal);//总价

				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				bDetail.setBdetId(uuid);//采购详情id
				
				if(buy.getBuyId().equals(uuidOne)) {
					bDetail.setBuyId(uuidOne);//采购id
				}else {
					bDetail.setBuyId(buyId);//采购id
				}
				
				bDetail.setBdetAmount(Integer.valueOf(bdetAmount));//药品数量
				bDetail.setBdetPrice(bdetPrices);//药品单价额
				bDetail.setBdetTotal(bdetTotals);//药品总价
				bDetail.setBdetFkId(bdetFkId);//药品id
				bDetail.setIsva("有效");
				bDetail.setOper(admin.getAdminName());
				bDetail.setOptime(new Date());
				//采购详情增加
				buyRows =insertSelective(bDetail);
				
				if(i==0) {
					
					//给销售单定义一个id
					uuidTwo = UUID.randomUUID().toString().replaceAll("-", "");
					sale.setSaleId(uuidTwo);//销售id
					sale.setSaleTime(new Date());//销售时间
					sale.setSaleAmount(Integer.valueOf(amount));//销售总数
					sale.setSaleMoney(money);//订单总金额
					sale.setIsva("有效");
					sale.setOptime(new Date());
					sale.setOper(TimeUtil.getStrDate());
					//调用销售单增加的方法
					saleService.insertSelective(sale);
					
				}
				//定义一个销售订单详情的对象
				SaleDetail detail = new SaleDetail();
				
				detail.setDrugId(bdetFkId);//药品id
				detail.setSaleId(uuidTwo);//销售id
				detail.setSdAmount(Integer.valueOf(bdetAmount));//药品数量
				detail.setSdPrice(bdetPrices);//药品单价
				detail.setSdTotal(bdetTotals);//订单总金额
				detail.setIsva("有效");
				detail.setOptime(new Date());
				detail.setOper(TimeUtil.getStrDate());
				//增加销售详情
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
