package com.yidu.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.domain.Drug;
import com.yidu.service.DrugService;
import com.yidu.util.Message;
import com.yidu.util.UploadUtil;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 药品表 前端控制器
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Resource
	private DrugService drugService;
	
	/**
	 * 查询所有
	 * @return List<Drug> 药品集合
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> showList(Drug record) {
		List<Drug> list = drugService.findAll(record);
		@SuppressWarnings("unchecked")
		Map<String,Object> map = new HashedMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 上传文件
	 * @param req
	 * @return String 文件名
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest req) throws Exception {
		String fileName = UploadUtil.upload(req);
		Message mes = new Message();
		if (fileName!=null) {
			mes.setStatus(1);
			mes.setObj(fileName);
			mes.setMsg("上传成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("服务器错误，请稍后重试！");
		}
		return mes;
	}
	
	/**
	 * 增加新药品
	 * @return Message json信息类
	 */
	@RequestMapping("/addDrug")
	@ResponseBody
	public Message addDrug(@RequestBody Drug record) {
		int rows = drugService.addOrUpdate(record);
		Message mes = new Message();
		if (rows>0) {
			mes.setStatus(1);
			mes.setMsg("操作成功");
		} else {
			mes.setStatus(0);
			mes.setMsg("数据异常，请稍后重试！");
		}
		return mes;
	}
}

