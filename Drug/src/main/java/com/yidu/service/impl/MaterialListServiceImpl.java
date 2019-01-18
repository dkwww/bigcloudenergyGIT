package com.yidu.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.AuditMapper;
import com.yidu.dao.MaterialListMapper;
import com.yidu.domain.Audit;
import com.yidu.domain.MaterialList;
import com.yidu.service.MaterialListService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 物料清单 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class MaterialListServiceImpl  implements MaterialListService {
	
	@Resource
	private MaterialListMapper materialListMapper;//注入物料清单导类
	@Resource
	private AuditMapper auditMapper;//注入审核导类

	@Override
	public List<MaterialList> findAll(MaterialList record,PageUtil pageUtil) {
		//获得一个map对象
		Map<String, Object> map = new HashMap<String, Object>();
		//赋值需要查询的条件
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询并放回结果
		return materialListMapper.selectBySelective(map);
	}

	@Override
	public int findCount(MaterialList record) {
		//获得总行数并返回结果
		return materialListMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(MaterialList record) {
		//操作时间赋值
		record.setOptime(new Date());
		//如果物料清单id不为空
		if (record.getMlId()!=null&&!"".equals(record.getMlId())) {
			//定义处理的行数
			int rows = 0;
			//判断审核状态为 未审核 、总经理审核且不能为空
			if (!"-1".equals(record.getAudState()) && !"10112".equals(record.getAudState()) && !"10113".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				//获得审核模型类
				Audit audit = new Audit();
				//赋值需要修改的审核id
				audit.setAudId(record.getAudId());
				//如果审核状态为总经理审核不通过
				if ("10110".equals(record.getAudState())) {
					//赋值第二种不通过的状态
					audit.setAudState("10112");
				//如果审核状态为总经理审核通过
				} else if ("10111".equals(record.getAudState())) {
					//赋值第二种通过的状态
					audit.setAudState("10113");
				}
				//进行修改 审核表审核状态 并赋值处理的行数
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			//如果修改审核表审核状态成功
			if (rows>0) {
				//进行修改 物料明细 并赋值处理的行数
				rows = materialListMapper.updateByPrimaryKeySelective(record);
			} else {
				//初始化处理的行数
				rows = 0;
			}
			//返回处理的行数
			return rows;
		} else {
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//进行增加 物料明细 并返回处理的行数
			return materialListMapper.insertSelective(record);
		}
		
	}

}
