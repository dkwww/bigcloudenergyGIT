package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Admin;
import com.yidu.domain.DrugInvDetail;
import com.yidu.domain.DrugInve;
import com.yidu.domain.Qc;
import com.yidu.domain.QcDetail;
import com.yidu.service.DrugInvDetailService;
import com.yidu.service.DrugInvService;
import com.yidu.service.QcDetailService;
import com.yidu.service.QcService;
import com.yidu.util.Message;
import com.yidu.util.TimeUtil;

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
 * 药品库存明细 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drugInvDetail")
public class DrugInvDetailController {
	//库存service
	@Resource
	DrugInvService   drugInvService;
	//库存明细service
	@Resource
	private   DrugInvDetailService   drugInvDetailService;
	//质检明细service
	@Resource
	private QcDetailService qcdetaService;
	//质检service
	@Resource
	private    QcService  qcService;

	/**
	 * 根据ID差看库存详细
	 * @param drugInvDetail
	 * @author Pngjiangping
	 * @date：2019年1月9日 
	 * @return  map  layui的格式
	 */
	@RequestMapping("findById")
	@ResponseBody
	public   Map<String , Object>  findById(DrugInvDetail drugInvDetail){
		//调用根据ID查询库存详细的方法
		List<DrugInvDetail> list = drugInvDetailService.findById(drugInvDetail.getDiId());
		for (DrugInvDetail drugInvDetail2 : list) {
			//时间转换为String类型
			drugInvDetail2.setTimeName(TimeUtil.dateToString(drugInvDetail2.getOptime(), "yyyy-MM-dd HH:mm:ss"));
		}
		//根据ID查询行数
		int    rows=drugInvDetailService.selectcount(drugInvDetail.getDiId());
		//返回前台layui格式
		Map<String, Object>  map  =new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", rows);
		map.put("data", list);
		//返回map
		return  map;
	}
	/**
	 * 增加库存和库存明细
	 * @param qc
	 * @author Pngjiangping
	 * @date：2019年1月9日 
	 * @return  提示信息
	 */
	@RequestMapping("addAll")
	@ResponseBody
	public   Message   addAll(Qc  qc ,HttpSession  session) { 
		//返回一个提示信息
		Message  message  =new  Message() ;
		//根据质检的Id查出所有的信息
		List<QcDetail> list = qcdetaService.selectQcId(qc.getQcId());
		//获取店铺s
		
		//定义一个rows 看是否增加成功
		int  rows =0;
		//将集合遍历
		for (QcDetail qcDetail : list) {
			//创建一个库存接收对象
			DrugInve   drugInve  =new DrugInve();
			//创建一个库存明细接收对象
			DrugInvDetail  drugInvDetail  = new  DrugInvDetail();
			//这个是库存的UUID 
			String    string= UUID.randomUUID().toString().replaceAll("-", "");
			//这是库存明细的UUID  
			String     str= UUID.randomUUID().toString().replaceAll("-", "");
			//获取质检明细的业务ID  
			drugInve.setDrugId(qcDetail.getQdetFkId());
			//获取session
			Admin  ad=(Admin) session.getAttribute("admin");
			//获取session里面的店铺ID
			drugInve.setComId(ad.getComId());
			//判断库存有没有这个药品
			List<DrugInve> drugList = drugInvService.selectDrugId(drugInve);
			
			 
			//如果集合为空     就在库存里加一行  如果不为空  就直接加数量
			if (!drugList.isEmpty()) {
				// 用库存对象接收值然后增加。。
				//药品ID 
				drugInve.setDrugId(qcDetail.getQdetFkId());
				System.err.println();
				//库存数量    用 查出来的质检总数  减去未通过的数量
				int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				//应该入库的数量
				drugInve.setDiAmount(sum);
				Admin  admin=(Admin) session.getAttribute("admin");
				drugInve.setComId(admin.getComId());
				 
				//增加库存数量
				drugInvService.updateamount(drugInve);
				//这是增加库存明细
				//使用UUID
				drugInvDetail.setDidId(str);
				//这是外键
				for (DrugInve drugInve2 : drugList) {
					//库存明细的外键是库存的主键
					drugInvDetail.setDiId(drugInve2.getDiId());
					 
				}
				//入库了多少个药品
				int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInvDetail.setDiAmount(sums);
				//默认为入库 
				drugInvDetail.setRemarks(0);
				//当前时间
				Date date  =new Date();
				//加入当前时间
				drugInvDetail.setOptime(date);
				//增加一条库存明细
				rows=drugInvDetailService.insert(drugInvDetail);
				
				 
				//否则的话就是没有这条信息
			} else {
				//商家ID
				drugInve.setComId("0");
				//增加的药品ID
				drugInve.setDrugId(qcDetail.getQdetFkId());
				//库存数量    用 查出来的质检总数  减去未通过的数量
				int  sum=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInve.setDiAmount(sum);
				//设置默认为
				drugInve.setDiComtype("0");
				//  主键ID为UUID
				drugInve.setDiId(string);
				//增加库存
				rows = drugInvService.insert(drugInve);
				//增加库存明细
				//明细主键
				drugInvDetail.setDidId(str);
				//库存明细的外键是库存的主键
				drugInvDetail.setDiId(string);
				//入库数量
				int  sums=qcDetail.getQdetAmount()-qcDetail.getQdetFail();
				drugInvDetail.setDiAmount(sums);
				//默认为入库
				drugInvDetail.setRemarks(0);
				//当前时间
				Date date  =new Date();
				//加入当前时间
				drugInvDetail.setOptime(date);
				//增加明细
				drugInvDetailService.insert(drugInvDetail);
			} 
		}
		//将质检的状态改成已提交库存
		Qc  qc2  = new  Qc();
		//根据ID修改状态
		qc2.setQcId(qc.getQcId());
		//将状态改为已提交
		qc2.setQcPut("1");
		//调用修改的方法
		qcService.updateByPrimaryKeySelective(qc2);

		//返回提示信息
	 
		if (rows>0) {
			//返回
			message.setStatus(1);
			//提示信息
			message.setMsg("入库成功");
		}else {
			//返回1
			message.setStatus(0);
			//提示信息
			message.setMsg("入库失败");
		} 
		//返回提示对象
		return  message;
	}

} 