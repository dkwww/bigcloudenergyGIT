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
 * 分店销售 服务实现类
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
	 * @param util 分页model
	 * @param branchSale 零售model
	 * @return 零售mapper里面查询所有的方法
	 */
	@Override
	public List<BranchSale> query(PageUtil util, BranchSale branchSale) {
		//创建一个Map集合
		Map<String, Object> map=new HashMap<>();
		//取到分页model
		map.put("util", util);
		//取到零售model
		map.put("branchSale", branchSale);
		//返回dao类查询所有的方法
		return mapper.selectAll(map);
	}
	/**
	 * 分页
	 * @param branchSale 零售model
	 * @return 零售mapper里面分页查询的方法
	 */
	@Override
	public int findCount(BranchSale branchSale) {
		//调用零售mapper里面分页查询的方法
		return mapper.findCount(branchSale);
	}
	/**
	 * 增加
	 * @param branchSale 零售model
	 * @return 零售mapper里面增加的方法
	 */
	@Override
	public int insertSelective(BranchSale branchSale) {
		//调用零售mapper里面增加的方法
		return mapper.insertSelective(branchSale);
	}
	/**
	 * 添加到零售明细
	 * @param sum 和
	 * @param menId 会员ID
	 * @param comId 店铺ID
	 */
	@Override
	public Message addSale(String sum, String menId, String comId) {
		//调用会员mapper里面查询的方法
		Member member=menberMapper.selectByPrimaryKey(menId);
		//设置折扣为null
		Double zk=null;
		//如果是普通会员
		if("普通会员".equals(member.getOper())) {
			//折扣为0.9
			zk=0.9;
		//如果是高级会员
		}else if("高级会员".equals(member.getOper())) {
			//折扣为0.85
			zk=0.85;
		//如果是顶级会员
		}else if("顶级会员".equals(member.getOper())) {
			//折扣为0.8
			zk=0.8;
		//如果是非会员
		}else if("非会员".equals(member.getOper())) {
			//折扣为1.00
			zk=1.00;
		}
		
		//创建一个Message对象
		Message message=new Message();
		//设置row为0
		Integer row=0;
		//设置rows为0
		Integer rows=0;
		//设置count为0
		Integer count=0;
		//设置money为0.0
		Double money=0.0;
		//用@符号拆分
		String [] su=sum.split("@");
		//for循环
		for (String string : su) {
			//用逗号分隔
			String [] arr=string.split(",");
			//总数量
			count+=Integer.valueOf(arr[1]);
			//调用药品mapper里面查询的方法
			Drug drug=drugMapper.selectByPrimaryKey(arr[0]);
			//总金额
			money+=(drug.getDrugPrice().doubleValue()*zk)*Integer.valueOf(arr[1]);
		}
		//取到总金额和总数量
		message.setMsg("总金额: "+money.doubleValue()+"  总数量: "+count);
		
		//创建一个零售类
		BranchSale branchSale=new BranchSale();
		//取到零售ID
		branchSale.setBsId(Tools.getDateOrderNo());
		//取到零售里面的店铺ID
		branchSale.setComId(comId);
		//取到零售里面的会员ID
		branchSale.setMenId(menId);
		//取到零售数量
		branchSale.setBsAmount(count);
		//取到零售价格
		branchSale.setBsPrice(money.toString());
		//取到零售是否有效
		branchSale.setIsva("1");
		//取到零售操作时间
		branchSale.setOptime(new Date());
		//取到零售排序
		branchSale.setSort(Tools.getTimeStamp());
		//调用零售mapper里面增加的方法
		row=mapper.insertSelective(branchSale);
		//调用财务mapper里面查询的方法
		Debty debty=debtymapper.findByComId(comId);
		//取到财务总资产
		debty.setDebMoney(new BigDecimal(debty.getDebMoney().intValue()+money));
		//调用财务mapper里面修改的方法
		debtymapper.updateByPrimaryKeySelective(debty);
		//创建一个财务明细对象
		DebtyDetail debtyDetail=new DebtyDetail();
		//取到财务明细ID
		debtyDetail.setDdetId(Tools.getDateOrderNo());
		//取到财务明细里面的财务ID
		debtyDetail.setDebId(debty.getDebId());
		//取到财务明细资金变动
		debtyDetail.setDdetChange(new BigDecimal(money));
		//取到财务明细是否有效
		debtyDetail.setIsva("1");
		//取到财务明细操作时间
		debtyDetail.setOptime(new Date());
		//调用财务明细mapper里面增加的方法
		debtyDetailMapper.insertSelective(debtyDetail);
		for (String string : su) {
			//根据逗号分隔
			String [] arr=string.split(",");
			
			//创建一个零售明细类
			BranchSaleDetail branchSaleDetail=new BranchSaleDetail();
			//取到零售明细ID
			branchSaleDetail.setBsdId(Tools.getDateOrderNo());
			//取到零售明细里面的零售ID
			branchSaleDetail.setBsId(branchSale.getBsId());
			//取到零售明细里面的药品ID
			branchSaleDetail.setDrugId(arr[0]);
			//取到零售明细数量
			branchSaleDetail.setBsdAmount(Integer.valueOf(arr[1]));
			//调用药品mapper里面查询的方法
			Drug drug=drugMapper.selectByPrimaryKey(arr[0]);
			//取到零售明细单价
			branchSaleDetail.setBsdPrice(drug.getDrugPrice().toString());
			//取到零售明细小计
			branchSaleDetail.setBsdTotal((drug.getDrugPrice().doubleValue()*branchSaleDetail.getBsdAmount())+"");
			//取到零售明细是否有效
			branchSaleDetail.setIsva("1");
			//取到零售明细操作时间
			branchSaleDetail.setOptime(new Date());
			//取到零售明细排序
			branchSaleDetail.setSort(Tools.getTimeStamp());
			//调用零售明细mapper里面增加的方法
			rows=branchSaleDetailMapper.insertSelective(branchSaleDetail);
			//创建一个map集合
			Map<String, Object> map=new HashMap<>();
			//取到药品ID
			map.put("drugId", arr[0]);
			//取到店铺ID
			map.put("comId", comId);
			//调用库存mapper里面查询的方法
			DrugInve drugInve=inveMapper.findDrugId(map);
			//取到库存数量
			drugInve.setDiAmount(drugInve.getDiAmount()-Double.valueOf(branchSaleDetail.getBsdAmount()).intValue());
			//调用库存mapper里面修改的方法
			inveMapper.updateByPrimaryKeySelective(drugInve);
			
			//增加库存记录
			//创建库存明细对象
			DrugInvDetail drugInvDetail=new DrugInvDetail();
			//取到库存明细ID
			drugInvDetail.setDidId(Tools.getDateOrderNo());
			//取到库存明细里面的库存ID
			drugInvDetail.setDiId(drugInve.getDiId());
			//取到库存明细里面的库存数量
			drugInvDetail.setDiAmount(Double.valueOf(branchSaleDetail.getBsdTotal()).intValue());
			//取到库存明细操作时间
			drugInvDetail.setOptime(new Date());
			//取到库存明细备注
			drugInvDetail.setRemarks(0);
			//调用财务明细mappeer里面增加的方法
			invDetailMapper.insert(drugInvDetail);
			
		}
		//如果row等于1，并且rows等于1
		if(row==1 && rows==1) {
			//取到1
			message.setStatus(1);
			//返回message
			return message;
		//否则
		}else {
			//取到0
			message.setStatus(0);
			//返回message
			return message;
		}
	}
	/**
	 * 根据店铺iD查询总额
	 */
	@Override
	public int querySaleNum(String id) {
		//返回mapper里面根据ID查询总额的方法
		return mapper.querySaleNum(id);
	}
}