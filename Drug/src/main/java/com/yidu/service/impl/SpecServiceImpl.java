package com.yidu.service.impl;
 
import com.yidu.dao.AuditMapper;
import com.yidu.dao.MaterialListMapper;
import com.yidu.dao.SpecMapper;
import com.yidu.domain.Audit;
import com.yidu.domain.MaterialList;
import com.yidu.domain.Spec;
import com.yidu.service.SpecService;

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
	private SpecMapper specMapper;
	@Resource
	private AuditMapper auditMapper;
	
	@Resource
	private MaterialListMapper materialListMapper;

	@Override
	public Spec findById(String drugId) {
		List<MaterialList> list = materialListMapper.selectByDrug(drugId);
		String str = "";
		if (list.size()<1) str = "未配置";
		for (int i = 0; i < list.size(); i++) {
			MaterialList materialList = list.get(i);
			if (i == list.size()-1) {
				str += materialList.getMatName()+"。";
			} else {
				str += materialList.getMatName()+"，";
			}
		}
		Spec spec = specMapper.selectByPrimaryKey(drugId);
		if (spec!=null) spec.setSpecComponent(str);
		return spec;
	}

	@Override
	public int addOrUpdate(Spec record) {
		if (record.getSpecId()!=null&&!"".equals(record.getSpecId())) {
			int rows = 1;
			if (!"-1".equals(record.getAudState()) && !"10012".equals(record.getAudState()) && !"10013".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				Audit audit = new Audit();
				audit.setAudId(record.getAudId());
				if ("10010".equals(record.getAudState())) {
					audit.setAudState("10012");
				} else if ("10011".equals(record.getAudState())) {
					audit.setAudState("10013");
				}
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			
			if (rows>0) {
				return specMapper.updateByPrimaryKeySelective(record);
			} else {
				return 0;
			}
		} else {
			record.setIsva("1");
			record.setOptime(new Date());
			return specMapper.insertSelective(record);
		}
	}

}
