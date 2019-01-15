package com.yidu.service.impl;
 
import com.yidu.dao.AuditMapper;
import com.yidu.dao.MaterialListMapper;
import com.yidu.dao.SpecMapper;
import com.yidu.domain.Audit;
import com.yidu.domain.MaterialList;
import com.yidu.domain.Spec;
import com.yidu.service.SpecService;
import com.yidu.util.TimeUtil;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 说明书 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class SpecServiceImpl   implements SpecService {
	
	@Resource
	private SpecMapper specMapper;//注入说明书导类
	@Resource
	private AuditMapper auditMapper;//注入审核导类
	@Resource
	private MaterialListMapper materialListMapper;//注入药品物料清单导类

	@Override
	public Spec findById(String drugId) {
		//根据药品id查询物料清单
		List<MaterialList> list = materialListMapper.selectByDrug(drugId);
		//定义并初始化局域变量并初始化
		String str = "";
		//如果没有物料清单将局域变量赋值未配置
		if (list.size()<1) str = "未配置";
		//循环遍历
		for (int i = 0; i < list.size(); i++) {
			MaterialList materialList = list.get(i);
			if (i == list.size()-1) {
				str += materialList.getMatName()+"。";
			} else {
				str += materialList.getMatName()+"，";
			}
		}
		//根据药品id查询说明书
		Spec spec = specMapper.selectByPrimaryKey(drugId);
		//如果说明书不为空就将str赋值给成分
		if (spec!=null) spec.setSpecComponent(str);
		//返回说明书
		return spec;
	}

	@Override
	public int addOrUpdate(Spec record) {
		//如果说明书id不为空
		if (record.getSpecId()!=null&&!"".equals(record.getSpecId())) {
			//定义并初始化局域变量并初始化
			int rows = 1;
			//操作时间赋值
			record.setOptime(new Date());
			//判断审核状态
			if (!"-1".equals(record.getAudState()) && !"10112".equals(record.getAudState()) && !"10113".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				//获得审核模型类
				Audit audit = new Audit();
				//审核id赋值
				audit.setAudId(record.getAudId());
				//如果审核失败
				if ("10110".equals(record.getAudState())) {
					//审核状态赋值
					audit.setAudState("10112");
				} else if ("10111".equals(record.getAudState())) {
					//审核状态赋值
					audit.setAudState("10113");
				}
				//进行修改并返回处理的行数
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			//如果修改审核状态成功
			if (rows>0) {
				//进行修改并返回处理的行数
				return specMapper.updateByPrimaryKeySelective(record);
			} else {
				//直接返回0
				return 0;
			}
		} else {
			//赋值为有效状态
			record.setIsva("1");
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//进行增加并返回处理的行数
			return specMapper.insertSelective(record);
		}
	}

}
