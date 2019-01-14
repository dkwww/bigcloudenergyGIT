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
		//定义一个变量为0
		int rows=0;
		//判断如果不等于空 且 不为""
		if(qc.getQcId()!=null &&!"".equals(qc.getQcId())) {
			//调用dao的修改方法
			rows=dao.updateByPrimaryKeySelective(qc);
		}
		//返回rows
		return rows;
	}

	@Override
	public List<Qc> showList(Qc qc, PageUtil page) {
		//创建map对象
		Map<String, Object> map=new HashMap<>();
		//赋质检对象值
		map.put("qc", qc);
		//赋分页对象值
		map.put("page", page);
		//调用dao的查询所有方法
		return dao.showList(map);
	}

	@Override
	public int selectCount(Qc qc) {
		
		//调用dao的查询总行数方法
		return dao.selectCount(qc);
	}

	@Override
	public int addQc(Buy buy) {
		//定义一个变量为0
		int rows=0;
		//定义数量的变量
		Integer count=0;
		//根据采购订单id查询采购明细
		List<BuyDetail> list=detaMapper.findBuysId(buy.getBuyId());
		
		//循环明细所有
		for (BuyDetail buyDetail : list) {
			//把采购明细的数量循环出来
			count+=buyDetail.getBdetAmount();
		}
		//得到材料质检
		Qc qc=new Qc();
		//把采购订单的id添加到质检外键
		qc.setPmcId(buy.getBuyId());
		//默认未通过数为0
		qc.setQcFail(0);
		//默认总通过数为0
		qc.setQcRate("0");
		//默认质检状态为0
		qc.setQcState("0");
		//默认入库状态为0
		qc.setQcPut("0");
		//把上面循环出来的数量加入质检的数量
		qc.setQcAmount(count);
		//默认质检厂家为0
		qc.setQcConpany("0");
		//得到当前时间
		qc.setOptime(new Date());
		//uuid
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		//质检id
		qc.setQcId(uuid);
		//添加进数据库
		dao.insert(qc);
		
		//循环采购明细所有
		for (BuyDetail buyDetail : list) {
			//得到质检明细对象
			QcDetail detail=new QcDetail();
			//质检明细id
			detail.setQdetId(Tools.getDateOrderNo());
			//把质检id存入质检明细外键
			detail.setQcId(qc.getQcId());
			//质检明细数量
			detail.setQdetAmount(buyDetail.getBdetAmount());
			//默认未通过数为0
			detail.setQdetFail(0);
			//默认通过率为0
			detail.setQdetRate("0");
			//是否有效为1
			detail.setIsva("1");
			//得到当前时间
			detail.setOptime(new Date());
			//排序
			detail.setSort(Tools.getTimeStamp());
			//把采购明细的id放入质检明细
			detail.setQdetFkId(buyDetail.getBdetFkId());
			//存入数据库
			rows=qcdetailMapper.insertSelective(detail);
		}
		
		return rows;
	}

	@Override
	public int update(Buy buy) {
		//定义一个变量
		int rows=0;
		//判断如果采购id不等于null 且 不等于空
		if(buy.getBuyId()!=null && !"".equals(buy.getBuyId())) {
			//就调用修改方法
			buyMapper.updateByPrimaryKeySelective(buy);
		}
		//返回rows
		return rows;
	}

	@Override
	public List<Qc> findById(String qcId) {
		
		//调用dao的根据id查询方法
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

	@Override
	public int branchQualityAdd(Buy buy) {
		System.err.println("          "+buy.getBuyId());
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
		qc.setQcType(3);
		//默认质检状态为0
		qc.setQcState("0");
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
			detail.setQdetFkId(buyDetail.getBdetFkId());
			rows=qcdetailMapper.insertSelective(detail);
		}
		
		return rows;
	}
}
