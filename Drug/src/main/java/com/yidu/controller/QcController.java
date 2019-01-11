package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.Drug;
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
 * @author dengkangwei
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

		List<Qc> list = qcService.selectqctype(qc, pageUtil);
		for (Qc qc2 : list) {
			qc2.setQcOptiemName(TimeUtil.dateToString(qc2.getQcOptime(), "yyyy-mm-dd"));
			qc2.setQcRateName(qc2.getQcRate()+"%");
		}
		int rows = qcService.selectCountBySelective(qc);
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
		String    string= UUID.randomUUID().toString().replaceAll("-", "");
		//分页
		Date   date =new Date();
		Message message  =new   Message();
		Pmc pmc = pmcService.selectById(qc.getPmcId());
		PmcDetails  pmcDetails=new   PmcDetails();
		pmcDetails.setPmcId(qc.getPmcId());
		List<PmcDetails>  list  = pmcDetailsService.selectPmcId(qc.getPmcId());
		for (PmcDetails pmcDetails2 : list) {
			String    strings= UUID.randomUUID().toString().replaceAll("-", "");
			QcDetail  qcDetail=  new   QcDetail();
			qcDetail.setQcId(string);
			qcDetail.setQdetFkId(pmcDetails2.getDrugId());
			qcDetail.setQdetId(strings);
			qcDetail.setQdetAmount(pmcDetails2.getPdAmount());
			qcDetail.setQdetFail(0);
			qcDetail.setQdetRate("0%");
			qcDetail.setQdetOptime(date);
			qcDetailService.insert(qcDetail);

		} 
		qc.setQcId(string);
		qc.setPmcId(pmc.getPmcId());
		qc.setQcAmount(pmc.getPmcAmount());
		qc.setQcRate("0");
		qc.setQcFail(0);
		qc.setQcConpany("总公司质检部");
		qc.setQcType(0); 
		qc.setQcState("0");
		qc.setQcPut("0");

		qc.setOptime(date);
		qc.setQcOptime(date); 
		int rows= qcService.add(qc); 
		
		 Mrp  mrp  =new  Mrp();
		 mrp.setMrpId(qc.getMrpId());
		 mrp.setMrpPud(1);
		  mrpService.updatepud(mrp);
		 
		
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}

		return  message;
	} 


	/**
	 * 
	 * 方法说明：材料质检显示列表
	 * @param qc 质检对象
	 * @param page
	 * @param limit
	 * @return
	 * @author dengkangwei
	 * @date：2018年12月27日
	 */
	@RequestMapping("QcbuyshowList")
	@ResponseBody
	public Map<String, Object> QcbuyshowList(Qc qc,Integer page,Integer limit){
		
		PageUtil PageUtil=new PageUtil();
		if(page!=null && limit!=null) {
			PageUtil.setCurPage(page);
			PageUtil.setRows(limit);
		}
		
		List<Qc> list=qcService.showList(qc, PageUtil);
		
		for (Qc qc2 : list) {
			if(qc2.getQcState().equals("0")) {
				qc2.setQcStates("未质检");
			}else if(qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}
			
			if(qc2.getQcPut().equals("0")) {
				qc2.setQcPuts("未入库");
			}else if(qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}
			
			//转为时间格式
			qc2.setOptimes(Tools.getDateStr(qc2.getOptime()));
		}
		
		int rows=qcService.selectCount(qc);
		
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
		//得到me对象
		Message me=new Message();
		//是1的话
		me.setStatus(1);
		me.setMsg("操作成功");
		
		return me;
	}


	/**
	 * 材料质检完后入库
	 * @author dengkangwei
	 * @param qc
	 * @return
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
			System.out.println("-------------进入这里");
			//在根据质检明细的id查找库存
			MatInv invlist=invservice.findQcId(qcDetail.getQdetFkId());
			
			System.err.println("----------库存当前数量"+invlist.getMiAmount());
			System.err.println("----------质检明细的数量:"+qcDetail.getQdetAmount());
			System.err.println("----------库存id:"+invlist.getMiId());
			//调用库存的增加方法,根据库存id修改库存数量
			invservice.updateAmount(qcDetail.getQdetAmount(), invlist.getMiId());
			
			//库存明细
			MatInvDetail invdetail=new MatInvDetail();
			//赋值库存明细id (DateOrderNo)
			invdetail.setMidId(Tools.getDateOrderNo());
			//赋值库存明细的库存id 外键
			invdetail.setMiId(invlist.getMiId());
			//赋值数量
			invdetail.setMidAmount(qcDetail.getQdetAmount());
			//调用库存明细增加方法
			invdetailservice.addkcdetail(invdetail);
		}
		
		Message me=new Message();
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
		session.getAttribute("user");
		
		List<Qc> list=qcService.branchQuality(qc, PageUtil);
		for (Qc qc2 : list) {
			if(qc2.getQcState().equals("0")) {
				qc2.setQcStates("未质检");
			}else if(qc2.getQcState().equals("1")) {
				qc2.setQcStates("已质检");
			}
			
			if(qc2.getQcPut().equals("0")) {
				qc2.setQcPuts("未入库");
			}else if(qc2.getQcPut().equals("1")) {
				qc2.setQcPuts("已入库");
			}
			//转为时间格式
			qc2.setOptimes(Tools.getDateStr(qc2.getOptime()));
		}
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
			System.out.println("-------------进入这里");
			System.out.println("    分店药品库存"+qcDetail.getQdetFkId());
			//在根据质检明细的id查找库存
			DrugInve drug = druginvService.findBydrugId(qcDetail.getQdetFkId());
			if(drug!=null&& drug.getDrugId()!=null&&!"".equals(drug.getDrugId())) {
				System.err.println("----------库存当前数量"+drug.getDiAmount());
				System.err.println("----------质检明细的数量:"+qcDetail.getQdetAmount());
				System.err.println("----------库存id:"+drug.getDiId());
				druginvService.updateAmounts(qcDetail.getQdetAmount(), drug.getDiId());
				
				//库存明细
				DrugInvDetail drugInvDetail=new DrugInvDetail();
				drugInvDetail.setDiId(drug.getDiId());
				drugInvDetail.setDiAmount(qcDetail.getQdetAmount());
				druginvDetailService.insertSelective(drugInvDetail);
				
			}else {

				uuid = UUID.randomUUID().toString().replaceAll("-", "");
				DrugInve drugInve = new DrugInve();
				drugInve.setDiId(uuid);
				drugInve.setComId(admin.getComId());
				drugInve.setDrugId(qcDetail.getQdetFkId());
				drugInve.setDiAmount(qcDetail.getQdetAmount());
				
				druginvService.insertSelective(drugInve);
				
				//库存明细
				DrugInvDetail drugInvDetail=new DrugInvDetail();
				drugInvDetail.setDiId(uuid);
				drugInvDetail.setDiAmount(qcDetail.getQdetAmount());
				druginvDetailService.insertSelective(drugInvDetail);
			}
		}
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");

		return me;
	}
}

