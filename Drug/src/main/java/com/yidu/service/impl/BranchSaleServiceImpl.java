package com.yidu.service.impl;

 
import com.yidu.dao.BranchSaleDetailMapper;
import com.yidu.dao.BranchSaleMapper;
import com.yidu.dao.DrugMapper;
import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.domain.Drug;
import com.yidu.service.BranchSaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 分店销售 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class BranchSaleServiceImpl implements BranchSaleService {
	/**
	 * 注入销售单Mapper
	 */
	@Resource
	private  BranchSaleMapper mapper;
	@Resource
	BranchSaleDetailMapper branchSaleDetailMapper;
	@Resource
	DrugMapper drugMapper;

	@Override
	public List<BranchSale> query(PageUtil util, BranchSale branchSale) {
		//new一个Map集合
		Map<String, Object> map=new HashMap<>();
		map.put("util", util);
		map.put("branchSale", branchSale);
		//返回dao类查询所有的方法
		return mapper.selectAll(map);
	}
	/**
	 * 分页
	 */
	@Override
	public int findCount(BranchSale branchSale) {
		return mapper.findCount(branchSale);
	}
	@Override
	public int insertSelective(BranchSale branchSale) {
		return mapper.insertSelective(branchSale);
	}
	/**
	 * 添加到零售明细
	 */
	@Override
	public Message addSale(String sum, String menId, String comId) {
		Message message=new Message();
		Integer row=0;
		Integer rows=0;
		Integer count=0;
		Double money=0.0;
		String [] su=sum.split("@");
		for (String string : su) {
			String [] arr=string.split(",");
			count+=Integer.valueOf(arr[1]);
			Drug drug=drugMapper.selectByPrimaryKey(arr[0]);
			money+=drug.getDrugPrice().doubleValue()*Integer.valueOf(arr[1]);
		}
		message.setMsg("总金额: "+money+"  总数量: "+count);
		
		BranchSale branchSale=new BranchSale();
		branchSale.setBsId(Tools.getDateOrderNo());
		branchSale.setComId(comId);
		branchSale.setMenId(menId);
		branchSale.setBsAmount(count);
		branchSale.setBsPrice(money.toString());
		branchSale.setIsva("1");
		branchSale.setOptime(new Date());
		branchSale.setSort(Tools.getTimeStamp());
		row=mapper.insertSelective(branchSale);
		
		for (String string : su) {
			String [] arr=string.split(",");
			
			BranchSaleDetail branchSaleDetail=new BranchSaleDetail();
			branchSaleDetail.setBsdId(Tools.getDateOrderNo());
			branchSaleDetail.setBsId(branchSale.getBsId());
			branchSaleDetail.setDrugId(arr[0]);
			branchSaleDetail.setBsdAmount(Integer.valueOf(arr[1]));
			Drug drug=drugMapper.selectByPrimaryKey(arr[0]);
			branchSaleDetail.setBsdPrice(drug.getDrugPrice().toString());
			branchSaleDetail.setBsdTotal((drug.getDrugPrice().doubleValue()*branchSaleDetail.getBsdAmount())+"");
			branchSaleDetail.setIsva("1");
			branchSaleDetail.setOptime(new Date());
			branchSaleDetail.setSort(Tools.getTimeStamp());
			rows=branchSaleDetailMapper.insertSelective(branchSaleDetail);
		}
		if(row==1 && rows==1) {
			message.setStatus(1);
			return message;
		}else {
			message.setStatus(0);
			return message;
		}
		
	}
}
