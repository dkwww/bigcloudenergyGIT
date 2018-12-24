package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.MatInv;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.MatInvService;
import com.yidu.service.QcDetailService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.PageUtil;

import java.util.HashMap;
import java.util.Iterator;
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
	 private QcDetailService QcDetailService;
	 
	 @Resource
	 private MatInvService invservice;
	 
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
	public   Message    add(Qc  qc) {
		Message message  =new   Message();
		String    string= UUID.randomUUID().toString().replaceAll("-", "");
		qc.setQcId(string);
		String   pmcId="d6484a14498b47f78cccc1242f5eab6ewerdfc2d23e78fc9446cf96af250812f923a992";
		qc.setPmcId(pmcId);
		qc.setQcAmount(600);
		qc.setQcRate("50");
		
		int  rows = 1;
		if (rows>0) {
			message.setStatus(1);
		}else {
			message.setStatus(0);
		}
		
		return  message;
	}
	
	
	/**
	 * 材料质检显示列表
	 * @param qc
	 * @author 邓康威
	 * @return
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
	 * @param shuju
	 * @param sumAmout
	 * @param sumRate
	 * @author 邓康威
	 * @return
	 */
	@RequestMapping("Qcadd")
	@ResponseBody
	public Message Qcadd(String id,String shuju,String sumAmout,String sumRate) {
		Qc qc=new Qc();
		
		System.err.println("------------"+id);
		QcDetail qcdetail=new QcDetail();
		qc.setQcId(id);
		qc.setQcFail(Integer.valueOf(sumAmout));
		qc.setQcRate(sumRate);
		qcService.buyQcadd(qc);
		
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
			QcDetailService.add(qcdetail);
			
		}
		
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		
		return me;
	}
	
	
	/**
	 * 材料质检入库
	 * @author 邓康威
	 * @param qc
	 * @return
	 */
	@RequestMapping("addkc")
	@ResponseBody
	public Message addkc(@RequestBody Qc qc) {
		
		List<QcDetail> list=QcDetailService.findByIds(qc.getQcId());
		
		for (QcDetail qcDetail : list) {
			List<MatInv> invlist=invservice.findQcId(qcDetail.getQdetFkId());
			for (MatInv matInv : invlist) {
				matInv.setMiId(matInv.getMiId());
				matInv.setMiAmount(qcDetail.getQdetAmount());
				invservice.add(matInv);
			}
		}
		Message me=new Message();
		me.setStatus(1);
		me.setMsg("操作成功");
		
		return me;
	}
}

