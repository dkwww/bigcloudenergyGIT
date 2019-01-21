package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yidu.domain.Admin;
 
import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.MatInv;
import com.yidu.domain.MatInvDetail;
import com.yidu.domain.Mrp;
import com.yidu.domain.Pmc;
import com.yidu.domain.PmcDetails;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.DrugInvDetailService;
import com.yidu.service.DrugInvService;
import com.yidu.service.MatInvDetailService;
import com.yidu.service.MatInvService;
import com.yidu.service.MrpService;
import com.yidu.service.PmcDetailsService;
import com.yidu.service.PmcService;
import com.yidu.service.QcDetailService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;
import com.yidu.util.Tools;

import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 质检表 前端控制器
 * </p>
 *
 * @author pengjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/qc")
public class QcController {
	@Resource
	private   QcService   qcService;
	@Resource
	private PmcService pmcService;
	@Resource
	private PmcDetailsService pmcDetailsService;
	@Resource
	private DrugInvService druginvService;
	@Resource
	private DrugInvDetailService druginvDetailService;
	
	@Resource
	private QcDetailService   qcDetailService;
	@Resource
	private MatInvService invservice;
	@Resource
	private MrpService mrpService;
	
	@Resource
	private MatInvDetailService invdetailservice;

	/**
	 * 查询药品质检
	 * @param qc
	 * @param page
	 * @param limit
	 * @return
	 * @author Pngjiangping
	 */
	@RequestMapping("/qureyAll")
	@ResponseBody
	public   Map<String , Object>  qureyAll(Qc  qc  , Integer  page , Integer  limit){
		//分页
		PageUtil pageUtil = new PageUtil();
		//前台取过来的分页值
		pageUtil.setCurPage(page);
		pageUtil.setRows(limit);
		//查询药品质检
		List<Qc> list = qcService.selectqctype(qc, pageUtil);
		//遍历
		for (Qc qc2 : list) {
			//将时间转为String类型
			qc2.setQcOptiemName(TimeUtil.dateToString(qc2.getQcOptime(), "yyyy-MM-dd HH:mm:ss"));
			//改为百分比
			qc2.setQcRateName(qc2.getQcRate()+"%");
		}
		//查询行数
		int rows = qcService.selectCountBySelective(qc);
		//layui前台格式
		Map<String , Object>  map  =new  HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return  map;
	} 
	/**
	 * 增加质检和质检明细
	 * @param qc
	 * @return
	 * @author Pngjiangping
	 */  
	@RequestMapping("/add")
	@ResponseBody
	public   Message    add(Qc  qc ) {
		//质检明细的UUID
		String    string= UUID.randomUUID().toString().replaceAll("-", "");
		//创建当前时间
		Date   date =new Date();
		//返回提示信息
		Message message  =new   Message();
		//根据ID将所有的制造计划的信息查询出来
		Pmc pmc = pmcService.selectById(qc.getPmcId());
		//创建一个明细对象 用于接收值
		PmcDetails  pmcDetails=new   PmcDetails();
		//制造明细ID
		pmcDetails.setPmcId(qc.getPmcId());
		//将质检明细中的数据根据明细ID全部查出
		List<PmcDetails>  list  = pmcDetailsService.selectPmcId(qc.getPmcId());
		//遍历制造明细的集合
		for (PmcDetails pmcDetails2 : list) {
			//创建一个UUID
			String    strings= UUID.randomUUID().toString().replaceAll("-", "");
			//创建一个质检明细对象  用来接收所有制造明细的数据
			QcDetail  qcDetail=  new   QcDetail();
			//质检Id
			qcDetail.setQcId(string);
			//业务ID
			qcDetail.setQdetFkId(pmcDetails2.getDrugId());
			//质检明细ID
			qcDetail.setQdetId(strings);
			//质检明细数量
			qcDetail.setQdetAmount(pmcDetails2.getPdAmount());
			//质检明细状态
			qcDetail.setQdetFail(0);
			//默认百分之0
			qcDetail.setQdetRate("0%");
			//质检明细时间为当前时间
			qcDetail.setQdetOptime(date);
			//增加质检明细
			qcDetailService.insert(qcDetail);

		} 
		//质检ID
		qc.setQcId(string);
		//质检的业务ID
		qc.setPmcId(pmc.getPmcId());
		//质检的总数量
		qc.setQcAmount(pmc.getPmcAmount());
		//质检通过率默认为 0 
		qc.setQcRate("0");
		//质检通过数，默认为0
		qc.setQcFail(0);
		//默认为总公司的质检
		qc.setQcConpany("总公司质检部");
		//质检类型  0为药品 ，1为材料，2为分公司
		qc.setQcType(0); 
		//质检状态
		qc.setQcState("0");
		//入库状态
		qc.setQcPut("0");
		//操作时间
		qc.setOptime(date);
		//质检时间
		qc.setQcOptime(date); 
		//增加质检
		int rows= qcService.add(qc); 
		//下面是将制造计划 的状态改为已提交
		 Mrp  mrp  =new  Mrp();
		//将这个ID的制造计划的状态改为提交质检
		 mrp.setMrpId(qc.getMrpId());
		//状态改为1
		 mrp.setMrpPud(1);
		//修改
		mrpService.updatepud(mrp);
		 
		
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		//返回提示信息
		return  message;
	} 


	/**
	 * 
	 * 方法说明：材料质检显示列表
	 * @param qc 质检对象
	 * @param page 前台页数
	 * @param limit 前台行数
	 * @return
	 * @author dengkangwei
	 * @date：2018年12月27日
	 */
	@RequestMapping("QcbuyshowList")
	@ResponseBody
	public Map<String, Object> QcbuyshowList(Qc qc,Integer page,Integer limit){
		
		//得到分页对象
		PageUtil PageUtil = new PageUtil();
		//判断页数不等于空 且 行数不等于空
		if(page!=null && limit!=null) {
			//赋值前台传来的页数
			PageUtil.setCurPage(page);
			//赋值前台传来的行数
			PageUtil.setRows(limit);
		}
		
		//质检集合
		List<Qc> list=qcService.showList(qc, PageUtil);
		
		//循环质检所有
		for (Qc qc2 : list) {
			//质检状态"0"是未质检  "1"是已质检
			if(qc2.getQcState().equals("0")) {
				qc2.setQcStates("未质检");
			}else if(qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}
			
			//入库状态"0"是未入库 "1"是已入库
			if(qc2.getQcPut().equals("0")) {
				qc2.setQcPuts("未入库");
			}else if(qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}
			
			//转为时间格式
			qc2.setOptimes(Tools.getDateStr(qc2.getOptime()));
		}
		
		//查询质检总行数
		int rows=qcService.selectCount(qc);
		
		//创建map集合
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}


	/**
	 * 材料质检增加
	 * @param id
	 * @param shuju 前台传的数据
	 * @param sumAmout	未通过数
	 * @param zjAmout	质检总数量
	 * @param sumRate	总通过率
	 * @param qcState 	质检状态
	 * @author dengkangwei
	 * @return
	 */
	@RequestMapping("Qcadd")
	@ResponseBody
	public Message Qcadd(String id,String shuju,String sumAmout,String sumRate,String zjAmout,String qcState) {
		//得到质检对象
		Qc qc=new Qc();
		//把前台id赋到质检id
		qc.setQcId(id);
		//赋值未通过数
		qc.setQcFail(Integer.valueOf(sumAmout));
		//赋值总通过率
		qc.setQcRate(sumRate);
		//赋值质检总数量
		qc.setQcAmount(Integer.valueOf(zjAmout));
		//赋值质检状态
		qc.setQcState(qcState);
		//调用质检的增加方法
		qcService.buyQcadd(qc);
		
		//得到质检明细对象
		QcDetail qcdetail=new QcDetail();
		
		//根据前台传来的数据用"#"分割
		String [] data=shuju.split("#");
		
		//循环前台数据
		for (int i = 0; i < data.length; i++) {
			//用,分割
			String [] datas=data[i].split(",");
			//质检明细id[0]
			String qdetId=datas[0];
			//未通过数量[2]
			String qdetFail=datas[2];
			//数量[3]
			String qdetAmount=datas[3];
			//质检率[4]
			String qdetRate=datas[4];
			
			//赋值质检明细id
			qcdetail.setQdetId(qdetId);
			//赋值未通过数量
			qcdetail.setQdetFail(Integer.valueOf(qdetFail));
			//赋值数量
			qcdetail.setQdetAmount(Integer.valueOf(qdetAmount));
			//赋值质检率
			qcdetail.setQdetRate(qdetRate);
			//调用质检明细的增加方法
			qcDetailService.add(qcdetail);
			
		}
		//调用mes工具类
		Message me=new Message();
		//是1的话
		me.setStatus(1);
		me.setMsg("操作成功");
		
		return me;
	}


	/**
	 * 方法说明： 材料质检完后入库
	 * @param qc 质检对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月14日
	 */
	@RequestMapping("addkc")
	@ResponseBody
	public Message addkc(@RequestBody Qc qc) {

		//改库存状态
		qcService.buyQcadd(qc);
		
		//根据质检id查询质检明细
		List<QcDetail> list=qcDetailService.findkcId(qc.getQcId());
		//循环质检明细的内容
		for (QcDetail qcDetail : list) {
			//在根据质检明细的id查找库存
			MatInv invlist=invservice.findQcId(qcDetail.getQdetFkId());
			
			System.err.println("----------库存当前数量"+invlist.getMiAmount());
			System.err.println("----------质检明细的数量:"+qcDetail.getQdetAmount());
			System.err.println("----------库存id:"+invlist.getMiId());
			//调用库存的增加方法,根据库存id修改库存数量
			invservice.updateAmount(qcDetail.getQdetAmount(), invlist.getMiId());
			
			//库存明细
			MatInvDetail invdetail=new MatInvDetail();
			//库存明细主键 (DateOrderNo)
			invdetail.setMidId(Tools.getDateOrderNo());
			//赋值库存明细的库存id 外键
			invdetail.setMiId(invlist.getMiId());
			//赋值数量
			invdetail.setMidAmount(qcDetail.getQdetAmount());
			//赋值当前时间
			invdetail.setOptime(new Date());
			//调用库存明细增加方法
			invdetailservice.addkcdetail(invdetail);
		}
		
		//调用mes工具类
		Message me=new Message();
		//是1的话
		me.setStatus(1);
		me.setMsg("操作成功");

		return me;
	}
	
	/**
	 * 
	 * 方法说明：分店药品质检显示列表
	 * @param qc
	 * @param page
	 * @param limit
	 * @return
	 * @author zhengyouhong
	 * @date：2018年12月27日
	 */
	@RequestMapping("branchQuality")
	@ResponseBody
	public Map<String, Object> branchQuality(Qc qc,Integer page,Integer limit,HttpSession session){
		
		PageUtil PageUtil=new PageUtil();
		if(page!=null && limit!=null) {
			PageUtil.setCurPage(page);
			PageUtil.setRows(limit);
		}
		Admin admin =(Admin) session.getAttribute("admin");
		//查询所有
		List<Qc> list=qcService.branchQuality(qc, PageUtil,admin);
		for (Qc qc2 : list) {
			//质检状态
			if(qc2.getQcState().equals("0")) {
				qc2.setQcStates("未质检");
			}else if(qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}
			//入库状态
			if(qc2.getQcPut().equals("0")) {
				qc2.setQcPuts("未入库");
			}else if(qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}
			//转为时间格式
			qc2.setOptimes(Tools.getDateStr(qc2.getOptime()));
		}
		//查询库存行数
		int rows=qcService.selectCount(qc);
		
		Map<String, Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		return map;
	}
	
	
	/**
	 * 分店药品质检完后入库
	 * @author zhengyouhong
	 * @param qc
	 * @return Message
	 */
	@RequestMapping("branchAdd")
	@ResponseBody
	public Message branchAdd(@RequestBody Qc qc,HttpSession session) {
		//获取session
		Admin admin = (Admin) session.getAttribute("admin");
		
		String uuid=null;
		//改库存状态
		qcService.buyQcadd(qc);
		
		//根据质检id查询质检明细
		List<QcDetail> list=qcDetailService.selectQcId(qc.getQcId());
		//循环质检明细的内容
		for (QcDetail qcDetail : list) {
			//在根据质检明细的id查找库存
			DrugInve drug = druginvService.findBydrugId(qcDetail.getQdetFkId());
			if(drug!=null&& drug.getDrugId()!=null&&!"".equals(drug.getDrugId())) {
				//修改库存数量
				druginvService.updateAmounts(qcDetail.getQdetAmount(), drug.getDiId());
				
				//库存明细
				DrugInvDetail drugInvDetail=new DrugInvDetail();
				drugInvDetail.setDiId(drug.getDiId());//明细id
				drugInvDetail.setDiAmount(qcDetail.getQdetAmount());//明细数量
				drugInvDetail.setRemarks(2);//入库类型
				//增加明细
				druginvDetailService.insertSelective(drugInvDetail);
				
			}else {
				System.err.println("             库存数量"+qcDetail.getQdetAmount());
				uuid = UUID.randomUUID().toString().replaceAll("-", "");
				DrugInve drugInve = new DrugInve();
				drugInve.setDiId(uuid);//药品库存id
				drugInve.setComId(admin.getComId());//店铺id
				drugInve.setDrugId(qcDetail.getQdetFkId());//药品id
				drugInve.setDiAmount(qcDetail.getQdetAmount());//库存数量
				drugInve.setDiComtype("1");//公司类型
				//增加库存
				druginvService.insertSelective(drugInve);
				
				//库存明细
				DrugInvDetail drugInvDetail=new DrugInvDetail();
				drugInvDetail.setDiId(uuid);//库存明细id
				drugInvDetail.setDiAmount(qcDetail.getQdetAmount());//明细数量
				drugInvDetail.setRemarks(2);//入库类型
				//增加明细
				druginvDetailService.insertSelective(drugInvDetail);
			}
		}
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");

		return me;
	}
}

