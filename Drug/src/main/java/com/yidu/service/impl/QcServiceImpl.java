package com.yidu.service.impl;
 
import com.yidu.dao.AuditMapper;
import com.yidu.dao.BuyDetailMapper;
import com.yidu.dao.BuyMapper;
import com.yidu.dao.QcDetailMapper;
import com.yidu.dao.QcMapper;
import com.yidu.domain.Buy;
import com.yidu.domain.BuyDetail;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.QcService;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 质检表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class QcServiceImpl   implements QcService {
	@Resource
	private   QcMapper   dao;
	
	@Resource
	QcDetailMapper qcdetailMapper;
	@Resource
	private BuyMapper buyMapper;
	
	@Resource
	private BuyDetailMapper detaMapper;
	
	@Resource
	private AuditMapper audMapper;
	

	@Override
	public List<Qc> selectqctype(Qc qc, PageUtil pageUtil) {
		 Map<String , Object>  map  =new  HashMap<>();
		 map.put("qc", qc);
		 map.put("pageUtil", pageUtil);
		 List<Qc> list = dao.selectqctype(map);
		 for (Qc qc2 : list) {
			if (qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}else {
				qc2.setQcStates("未质检");
			}
			if (qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}else {
				qc2.setQcPuts("未入库");
			}
			
		}
		 
		return list;
	}

	@Override
	public int selectCountBySelective(Qc qc) {
		 
		return dao.selectCountBySelective(qc);
	}

	@Override
	public int buyQcadd(Qc qc) {
		int rows=0;
		if(qc.getQcId()!=null &&!"".equals(qc.getQcId())) {
			rows=dao.updateByPrimaryKeySelective(qc);
			
		}
		
		return rows;
	}

	@Override
	public List<Qc> showList(Qc qc, PageUtil page) {
		Map<String, Object> map=new HashMap<>();
		map.put("qc", qc);
		map.put("page", page);
		return dao.showList(map);
	}

	@Override
	public int selectCount(Qc qc) {
		
		return dao.selectCount(qc);
	}

	@Override
	public int addQc(Buy buy) {
		int rows=0;
		Integer count=0;
		//根据采购订单id查询采购明细
		List<BuyDetail> list=detaMapper.findBuyId(buy.getBuyId());
		for (BuyDetail buyDetail : list) {
			
			count+=buyDetail.getBdetAmount();
		}
		//得到材料质检
		Qc qc=new Qc();
		
		qc.setPmcId(buy.getBuyId());
		qc.setQcFail(0);
		qc.setQcRate("0");
		//默认质检状态为0
		qc.setQcState("0");
		qc.setQcPut("0");
		qc.setQcAmount(count);
		qc.setQcConpany("666");
		qc.setOptime(new Date());
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		qc.setQcId(uuid);
		dao.insert(qc);
		
		for (BuyDetail buyDetail : list) {
			
			QcDetail detail=new QcDetail();
			detail.setQdetId(Tools.getDateOrderNo());
			detail.setQcId(qc.getQcId());
			detail.setQdetAmount(buyDetail.getBdetAmount());
			detail.setQdetFail(0);
			detail.setQdetRate("0");
			detail.setIsva("1");
			detail.setOptime(new Date());
			detail.setSort(Tools.getTimeStamp());
			detail.setQdetFkId(buyDetail.getBdetFkId());
			rows=qcdetailMapper.insertSelective(detail);
		}
		
		return rows;
	}

	@Override
	public int update(Buy buy) {
		int rows=0;
		if(buy.getBuyId()!=null && !"".equals(buy.getBuyId())) {
			buyMapper.updateByPrimaryKeySelective(buy);
		}
		return rows;
	}

	@Override
	public List<Qc> findById(String qcId) {
		
		return dao.findById(qcId);
	}

	@Override
	public int updateByPrimaryKeySelective(Qc qc) {
		 int rows = dao.updateByPrimaryKeySelective(qc);
	
		return rows;
	}

	@Override
	public int add(Qc qc) {
	     
		return dao.insert(qc);
	}

	@Override
	public List<Qc> branchQuality(Qc qc, PageUtil pageUtil) {
		Map<String , Object>  map  =new  HashMap<>();
		 map.put("qc", qc);
		 map.put("pageUtil", pageUtil);
		 List<Qc> list = dao.branchQuality(map);
		 for (Qc qc2 : list) {
			if (qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}else {
				qc2.setQcStates("未质检");
			}
			if (qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}else {
				qc2.setQcPuts("未入库");
			}
			
		}
		 
		return list;
	}
	
	@Override
	public int qualityAdd(Buy buy) {
		int rows=0;
		Integer count=0;
		//根据采购订单id查询采购明细
		List<BuyDetail> list=detaMapper.findBuyId(buy.getBuyId());
		for (BuyDetail buyDetail : list) {
			
			count+=buyDetail.getBdetAmount();
		}
		//定义一个新的质检对象
		Qc qc=new Qc();
		
		qc.setPmcId(buy.getBuyId());
		qc.setQcFail(0);
		qc.setQcRate("0");
		//默认质检状态为0
		qc.setQcState("3");
		qc.setQcPut("0");
		qc.setQcAmount(count);
		qc.setQcConpany(buy.getComId());
		qc.setOptime(new Date());
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		qc.setQcId(uuid);
		dao.insertSelective(qc);
		
		for (BuyDetail buyDetail : list) {
			
			QcDetail detail=new QcDetail();
			detail.setQdetId(Tools.getDateOrderNo());
			detail.setQcId(qc.getQcId());
			detail.setQdetAmount(buyDetail.getBdetAmount());
			detail.setQdetFail(0);
			detail.setQdetRate("0");
			detail.setIsva("1");
			detail.setOptime(new Date());
			detail.setSort(Tools.getTimeStamp());
			detail.setQdetFkId(buy.getBuyId());
			rows=qcdetailMapper.insertSelective(detail);
		}
		
		return rows;
	}

}
