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
	/**
	 * 查询今年药品的销售次数
	 * @return
	 */
	@RequestMapping("queryList")
	@ResponseBody
	public Map<String,Object> queryList(HttpServletRequest request){
		HttpSession session=request.getSession();
		Admin user=(Admin) session.getAttribute("admin");
		int time[]={1,2,3,4,5,6,7,8,9,10,11,12};
		
		String dataname[]=new String[5];
		int rows=0;
		int index=0;
		List<Series> list=branService.queryName();
		Map<String,Object> map = new HashMap<>();
		List<Map<String,Object>> list2=new ArrayList<Map<String,Object>>();
			for(Series series:list) {
				Map<String,Object> but = new HashMap<>();
				List<Integer> data=new ArrayList<Integer>();
				for (int i = 0; i < time.length; i++) {
					rows=branService.queryId(time[i],series.getDrugId());
					data.add(rows);
				}
				but.put("stack", "受欢迎程度");
				but.put("name", series.getName());
				but.put("type","line");
				but.put("areaStyle",0);
				but.put("data", data);
				list2.add(but);
				dataname[index]=series.getName();
				index++;
			}
			map.put("data",list2);
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
}
