package com.yidu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.controller.vo.Repertory;
import com.yidu.controller.vo.Series;
import com.yidu.domain.Admin;
import com.yidu.domain.BranchSale;
import com.yidu.domain.BranchSaleDetail;
import com.yidu.domain.Role;
import com.yidu.domain.Sale;
import com.yidu.service.BranchSaleDetailService;
import com.yidu.service.BranchSaleService;
import com.yidu.service.DebtyService;
import com.yidu.service.DrugInvService;
import com.yidu.service.MatInvService;
import com.yidu.service.ModuleRoleService;
import com.yidu.service.RoleService;
import com.yidu.service.SaleService;
import com.yidu.util.Message;
/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private RoleService roleService;
	@Resource
	private ModuleRoleService moroService;
	@Resource
	private BranchSaleDetailService branService;
	@Resource
	private DrugInvService invService;
	@Resource
	private MatInvService  matService;
	@Resource
	private BranchSaleService saleService;
	@Resource
	private DebtyService devbService;
	/**
	 * 查询今年药品的销售次数
	 * @param request 用于获取返回的Session
	 * @return
	 */
	@RequestMapping("queryList")
	@ResponseBody
	public Map<String,Object> queryList(HttpServletRequest request){
		//获取Session
		HttpSession session=request.getSession();
		//获取当前登陆的用户
		Admin user=(Admin) session.getAttribute("admin");
		//定义一个月份数组
		int time[]={1,2,3,4,5,6,7,8,9,10,11,12};
		//定义一个String数组接收查询到的药品名称
		String dataname[]=new String[5];
		//定义一个数字用于循环增加
		int index=0;
		//根据店铺id查询最大的五个药品
		List<Series> list=branService.queryName(user.getComId());
		//定义一个Map用于返回
		Map<String,Object> map = new HashMap<>();
		//定义一个map类型的List用于获取查询的参数
		List<Map<String,Object>> list2=new ArrayList<Map<String,Object>>();
		//遍历查询到了5个药品
			for(Series series:list) {
				//定义一个map接收值
				Map<String,Object> but = new HashMap<>();
				//定义一个Integer类型的List接收值
				List<Integer> data=new ArrayList<Integer>();
				//循环月份数组
				for (int i = 0; i < time.length; i++) {
					//根据循环的月份和遍历的药品Id查询
					int rows=branService.queryId(time[i],series.getDrugId());
					//获取查询的值添入data
					data.add(rows);
				}
				//根据数据格式添加数据stack,受欢迎程度
				but.put("stack", "受欢迎程度");
				//添加药品name
				but.put("name", series.getName());
				//添加type，line
				but.put("type","line");
				//添加areaStyle,0
				but.put("areaStyle",0);
				//添加所有数据data
				but.put("data", data);
				//将map传入List
				list2.add(but);
				//将药品名称循环加入数组中
				dataname[index]=series.getName();
				//循环增加数字
				index++;
			}
			//传入data
			map.put("data",list2);
			//传入name
			map.put("name",dataname);
		return map;
	};
	@RequestMapping("queryRepertory")
	@ResponseBody
	public List<Repertory> queryRepertory(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("admin");
		List<Repertory> list=invService.queryBalance(user.getComId());
		return list;
	}
	@RequestMapping("queryMaterials")
	@ResponseBody
	public List<Repertory> queryMaterials(){
		List<Repertory> list=matService.queryMaterials();
		return list;
	}
	@RequestMapping("queryDrug")
	@ResponseBody
	public Message queryDrug(HttpServletRequest request){
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("admin");
		int rows=invService.queryDrug(user.getComId());
		Message mes=new Message();
		if(rows!=0) {
			mes.setStatus(rows);
		}else {
			mes.setStatus(0);
		}
		return mes;
	}
	@RequestMapping("queryMoney")
	@ResponseBody
	public Map<String,Object> queryMoney(HttpServletRequest request){
		HttpSession session=request.getSession();
		Map<String,Object> map=new HashMap<>();
		int index=0;
		String dataname[]=new String[7];
		int data[]=new int[7];
		Admin user=(Admin) session.getAttribute("admin");
		List<Series> list=branService.queryMoney(user.getComId());
		for (Series series : list) {
			dataname[index]=series.getName();
			data[index]=series.getIndexs();
			index++;
		}
		map.put("dataname",dataname);
		map.put("data",data);
		return map;
	}
	/**
	 * 查询销售总额
	 * @return
	 */
	@RequestMapping("querySaleNum")
	@ResponseBody
	public Message querySaleNum(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("admin");
		int rows=saleService.querySaleNum(user.getComId());
		Message mes=new Message();
		if(rows!=0) {
			mes.setStatus(rows);
		}else {
			mes.setStatus(0);
		}
		return mes;
	}
	/**
	 * 查询财务总额
	 * @return
	 */
	@RequestMapping("queryDebtyNum")
	@ResponseBody
	public Message queryDebtyNum(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("admin");
		int rows=devbService.queryDebtyNum(user.getComId());
		Message mes=new Message();
		if(rows!=0) {
			mes.setStatus(rows);
		}else {
			mes.setStatus(0);
		}
		return mes;
	}
}
