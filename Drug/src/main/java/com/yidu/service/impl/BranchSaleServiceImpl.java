package com.yidu.service.impl;

 
import com.yidu.dao.BranchSaleDetailMapper;
import com.yidu.dao.BranchSaleMapper;
import com.yidu.dao.DebtyDetailMapper;
import com.yidu.dao.DebtyMapper;
import com.yidu.dao.DrugInvDetailMapper;
import com.yidu.dao.DrugInveMapper;
import com.yidu.dao.DrugMapper;
import com.yidu.dao.MemberMapper;
import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.domain.Debty;
import com.yidu.domain.DebtyDetail;
import com.yidu.domain.Drug;
import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Member;
import com.yidu.service.BranchSaleService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.Tools;

import java.math.BigDecimal;
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
 * @author Liuyi
 * @since 2018-11-26
 */
@Service
public class BranchSaleServiceImpl implements BranchSaleService {
	/**
	 * 注入零售Mapper
	 */
	@Resource
	private  BranchSaleMapper mapper;
	/**
	 * 注入零售明细Mapper
	 */
	@Resource
	BranchSaleDetailMapper branchSaleDetailMapper;
	/**
	 * 注入药品Mapper
	 */
	@Resource
	DrugMapper drugMapper;
	/**
	 * 注入财务Mapper
	 */
	@Resource
	DebtyMapper debtymapper;
	/**
	 * 注入财务明细Mapper
	 */
	@Resource
	DebtyDetailMapper debtyDetailMapper;
	/**
	 * 注入库存Mapper
	 */
	@Resource
	DrugInveMapper inveMapper;
	/**
	 * 注入库存明细Mapper
	 */
	@Resource
	DrugInvDetailMapper invDetailMapper;
	/**
	 * 注入会员Mapper
	 */
	@Resource
	MemberMapper menberMapper;
	
	/**
	 * 查询所有
	 */
	@Override
	public List<BranchSale> query(PageUtil util, BranchSale branchSale) {
		//new一个Map集合
		Map<String, Object> map=new HashMap<>();
		//map取到页数
		map.put("util", util);
		//map取到model
		map.put("branchSale", branchSale);
		//返回dao类查询所有的方法
		return mapper.selectAll(map);
	}
	/**
	 * 分页
	 */
	@Override
	public int findCount(BranchSale branchSale) {
		//返回dao类分页的方法
		return mapper.findCount(branchSale);
	}
	/**
	 * 增加
	 */
	@Override
	public int insertSelective(BranchSale branchSale) {
		//返回dao类增加的方法
		return mapper.insertSelective(branchSale);
	}
	/**
	 * 添加到零售明细
	 */
	@Override
	public Message addSale(String sum, String menId, String comId) {
		//调用会员dao类查询的方法
		Member member=menberMapper.selectByPrimaryKey(menId);
		//折扣为空
		Double zk=null;
		//如果是“普通会员”
		if("普通会员".equals(member.getOper())) {
			//折扣价为0.9
			zk=0.9;
		//如果是“高级会员”
		}else if("高级会员".equals(member.getOper())) {
			//折扣价为0.85
			zk=0.85;
		//如果是“顶级会员”
		}else if("顶级会员".equals(member.getOper())) {
			//折扣价为0.8
			zk=0.8;
		//如果是“非会员”
		}else if("非会员".equals(member.getOper())) {
			//折扣价为1.00
			zk=1.00;
		}
		//创建一个Message类
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
			money+=(drug.getDrugPrice().doubleValue()*zk)*Integer.valueOf(arr[1]);
		}
		message.setMsg("总金额: "+money+"  总数量: "+count);
		//创建一个零售类
		BranchSale branchSale=new BranchSale();
		//赋值到零售ID
		branchSale.setBsId(Tools.getDateOrderNo());
		branchSale.setComId(comId);
		branchSale.setMenId(menId);
		branchSale.setBsAmount(count);
		branchSale.setBsPrice(money.toString());
		branchSale.setIsva("1");
		branchSale.setOptime(new Date());
		branchSale.setSort(Tools.getTimeStamp());
		row=mapper.insertSelective(branchSale);
		
		Debty debty=debtymapper.selectByPrimaryKey(comId);
		debty.setDebMoney(new BigDecimal(debty.getDebMoney().intValue()+money));
		debtymapper.updateByPrimaryKeySelective(debty);
		
		DebtyDetail debtyDetail=new DebtyDetail();
		debtyDetail.setDdetId(Tools.getDateOrderNo());
		debtyDetail.setDebId(debty.getDebId());
		debtyDetail.setDdetChange(new BigDecimal(money));
		debtyDetail.setIsva("1");
		debtyDetail.setOptime(new Date());
		debtyDetailMapper.insertSelective(debtyDetail);
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
			
			
			Map<String, Object> map=new HashMap<>();
			map.put("drugId", arr[0]);
			map.put("comId", comId);
			DrugInve drugInve=inveMapper.findDrugId(map);
			drugInve.setDiAmount(drugInve.getDiAmount()-Double.valueOf(branchSaleDetail.getBsdAmount()).intValue());
			inveMapper.updateByPrimaryKeySelective(drugInve);
			
			//增加库存记录
			DrugInvDetail drugInvDetail=new DrugInvDetail();
			drugInvDetail.setDidId(Tools.getDateOrderNo());
			drugInvDetail.setDiId(drugInve.getDiId());
			drugInvDetail.setDiAmount(Double.valueOf(branchSaleDetail.getBsdTotal()).intValue());
			System.err.println("数量"+drugInvDetail.getDiAmount());
			drugInvDetail.setOptime(new Date());
			drugInvDetail.setRemarks(0);
			invDetailMapper.insert(drugInvDetail);
			
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
