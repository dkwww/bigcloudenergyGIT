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
 * @author 郑有宏
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
		//把传过来的字符串根据&拆分成数组
		String[] str = mes.split("&");
		//定义一个采购订单对象
		Buy buy = new Buy();
		//定义一个销售订单对象
		Sale sale = new Sale();
		//定义一个审核对象
		Audit audit = new Audit();
		//采购订单的id
		String uuidOne = UUID.randomUUID().toString().replaceAll("-", "");
		//用于存储销售单的id
		String uuidTwo = null;
		
		for (int i = 0; i < str.length; i++) {
			BuyDetail bDetail = new BuyDetail();
			
			String[] strOne = str[i].split("#");
			//药品名称
 			String drugName = strOne[0];
 			//单价
			String bdetPrice = strOne[2];
			//数量单位
			String drugUnit = strOne[3];
			//总价
			String bdetTotal = strOne[5];
			//订单总价
			BigDecimal bdetTotals = new BigDecimal(bdetTotal);
			//订单总数量
			bdetAmount = strOne[8];
			//备注
			mess = strOne[9];
			//药品id
			String bdetFkId = strOne[10];
			//订单总数量
			String amount = strOne[11];
			//订单总金额
			BigDecimal money = new BigDecimal(strOne[12]);
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
					//订单id
					buy.setBuyId(uuidOne);
				}else {
					buy.setBuyId(buyId);//订单id
				}
				//店铺id
				buy.setComId(admin.getComId());
				//总购买数量
				buy.setBuyAmount(Integer.valueOf(amount));
				//订单总价
				buy.setBuyMoney(money);
				//采购时间
				buy.setBuyTime(new Date());
				//店铺
				buy.setBuyCompany("总店");
				//采购类型   1为药品   0为药材
				buy.setBuyType("1");
				//审核   1为采购中
				buy.setBuyAudit("1");
				//质检状态  默认0
				buy.setBuyQc("0");
				//采购状态
				buy.setBuyState("1");
				//入库状态
				buy.setBuyPut("0");
				//采购备注
				buy.setBuyMes(mess);
				//是否有效
				buy.setIsva("有效");
				//操作时间
				buy.setOptime(new Date());
				//操作人
				buy.setOper(admin.getAdminName());
				//排序
				buy.setSort(TimeUtil.getStrDate());
				
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
					//公司类型
					audit.setAudComtype("1");
					//公司id
					audit.setQcFkId(admin.getComId());
					//审核时间
					audit.setAudTime(new Date());
					//审核状态
					audit.setAudState("1");
					//审核意见
					audit.setAudIdea("分公司增加库存");
					//审核人
					audit.setAudName(admin.getAdminName());
					//审核
					audit.setAudMes(mess);
					//是否有效
					audit.setIsva("有效");
					//操作时间
					audit.setOptime(new Date());
					//操作人
					audit.setOper(admin.getAdminName());
					//排序
					audit.setSort(TimeUtil.getStrDate());
					//审核
					auditService.addOrUpdate(audit);
				}
				//单价
				BigDecimal bdetPrices = new BigDecimal(bdetPrice);

				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				//采购详情id
				bDetail.setBdetId(uuid);
				
				if(buy.getBuyId().equals(uuidOne)) {
					//采购id
					bDetail.setBuyId(uuidOne);
				}else {
					//采购id
					bDetail.setBuyId(buyId);
				}
				//药品数量
				bDetail.setBdetAmount(Integer.valueOf(bdetAmount));
				//药品单价额
				bDetail.setBdetPrice(bdetPrices);
				//药品总价
				bDetail.setBdetTotal(bdetTotals);
				//药品id
				bDetail.setBdetFkId(bdetFkId);
				//是否有效
				bDetail.setIsva("有效");
				//操作人
				bDetail.setOper(admin.getAdminName());
				//操作时间
				bDetail.setOptime(new Date());
				//采购详情增加
				buyRows =insertSelective(bDetail);
				
				if(i==0) {
					
					//给销售单定义一个id
					uuidTwo = UUID.randomUUID().toString().replaceAll("-", "");
					//销售id
					sale.setSaleId(uuidTwo);
					//销售时间
					sale.setSaleTime(new Date());
					//销售总数
					sale.setSaleAmount(Integer.valueOf(amount));
					//订单总金额
					sale.setSaleMoney(money);
					//是否有效
					sale.setIsva("有效");
					//操作时间
					sale.setOptime(new Date());
					//排序
					audit.setSort(TimeUtil.getStrDate());
					//操作人
					sale.setOper(admin.getAdminName());
					//调用销售单增加的方法
					saleService.insertSelective(sale);
					
				}
				//定义一个销售订单详情的对象
				SaleDetail detail = new SaleDetail();
				//药品id
				detail.setDrugId(bdetFkId);
				//销售id
				detail.setSaleId(uuidTwo);
				detail.setSdAmount(Integer.valueOf(bdetAmount));
				//药品数量
				detail.setSdPrice(bdetPrices);
				//药品单价
				detail.setSdTotal(bdetTotals);
				//订单总金额
				detail.setIsva("有效");
				//操作时间
				detail.setOptime(new Date());
				//排序
				audit.setSort(TimeUtil.getStrDate());
				//操作人
				detail.setOper(admin.getAdminName());
				//增加销售详情
				saleDetailService.addOrUpdate(detail);
				
			
			}else {
				//如果药品库存不足，则
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


	@Override
	public List<BuyDetail> findByBuyId(String buyId) {
		return mapper.findBuyId(buyId);
	}

}
