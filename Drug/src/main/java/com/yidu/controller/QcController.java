package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatInv;
import com.yidu.domain.MatInvDetail;
import com.yidu.domain.Mrp;
import com.yidu.domain.Pmc;
import com.yidu.domain.PmcDetails;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
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

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 质检表 前端控制器
 * </p>
 *
 * @author Pngjiangping
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
	private QcDetailService   qcDetailService;
	@Resource
	private MatInvService invservice;
	@Resource
	private MrpService mrpService;
	
	@Resource
	private MatInvDetailService invdetailservice;

	//查询 药品质检
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
		qc.setQcConpany("目前不知道是啥工厂");
		qc.setQcType(0); 
		qc.setQcState("0");
		qc.setQcPut("0");

		qc.setOptime(date);
		qc.setQcOptime(date); 
		int rows= qcService.add(qc); 
		 
		
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
	 * @param qc
	 * @param page
	 * @param limit
	 * @return
	 * @author dengknagwei
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
	 * @param shuju
	 * @param sumAmout
	 * @param sumRate
	 * @param qcState 质检状态
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("Qcadd")
	@ResponseBody
	public Message Qcadd(String id,String shuju,String sumAmout,String sumRate,String qcState) {
		Qc qc=new Qc();
		qc.setQcId(id);
		qc.setQcFail(Integer.valueOf(sumAmout));
		qc.setQcRate(sumRate);
		qc.setQcState(qcState);
		qcService.buyQcadd(qc);
		
		QcDetail qcdetail=new QcDetail();
		
		
		//根据前台传来的数据用"#"分割
		String [] data=shuju.split("#");
		
		for (int i = 0; i < data.length; i++) {
			String [] datas=data[i].split(",");
			String qdetId=datas[0];
			System.out.println("质检明细id:"+qdetId);
			String qdetFail=datas[2];
			System.out.println("未通过数量:"+qdetFail);
			String qdetAmount=datas[3];
			System.out.println("数量:"+qdetAmount);
			String qdetRate=datas[4];
			System.out.println("质检率:"+qdetRate);
			
			qcdetail.setQdetId(qdetId);
			qcdetail.setQdetFail(Integer.valueOf(qdetFail));
			qcdetail.setQdetRate(qdetRate);
			qcDetailService.add(qcdetail);
			
		}
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		
		return me;
	}


	/**
	 * 材料质检完后入库
	 * @author 邓康威
	 * @param qc
	 * @return
	 */
	@RequestMapping("addkc")
	@ResponseBody
	public Message addkc(@RequestBody Qc qc) {

		//改库存状态
		qcService.buyQcadd(qc);
		
		//根据质检id查询质检明细
		List<QcDetail> list=qcDetailService.findByIds(qc.getQcId());
		//循环质检明细的内容
		for (QcDetail qcDetail : list) {
			System.out.println("-------------进入这里");
			//在根据质检明细的id查找库存
			List<MatInv> invlist=invservice.findQcId(qcDetail.getQdetFkId());
			for (MatInv matInv : invlist) {
				System.err.println("----------库存当前数量"+matInv.getMiAmount());
				System.err.println("----------质检明细的数量:"+qcDetail.getQdetAmount());
				System.err.println("----------库存id:"+matInv.getMiId());
				
				invservice.updateAmount(qcDetail.getQdetAmount(), matInv.getMiId());
				
				//库存明细
				MatInvDetail invdetail=new MatInvDetail();
				invdetail.setMidId(Tools.getDateOrderNo());
				invdetail.setMiId(matInv.getMiId());
				invdetail.setMidAmount(qcDetail.getQdetAmount());
				invdetailservice.addkcdetail(invdetail);
			}
			
		}
		
		
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");

		return me;
	}
}

