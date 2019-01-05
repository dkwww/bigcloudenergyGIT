package com.yidu.service.impl;

 
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
	private MaterialListMapper materialListMapper;
	@Resource
	private AuditMapper auditMapper;

	@Override
	public List<MaterialList> findAll(MaterialList record,PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return materialListMapper.selectBySelective(map);
	}

	@Override
	public int findCount(MaterialList record) {
		return materialListMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(MaterialList record) {
		if (record.getMlId()!=null&&!"".equals(record.getMlId())) {
			int rows = 1;
			if (!"-1".equals(record.getAudState()) && !"10112".equals(record.getAudState()) && !"10113".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				Audit audit = new Audit();
				audit.setAudId(record.getAudId());
				if ("10110".equals(record.getAudState())) {
					audit.setAudState("10112");
				} else if ("10111".equals(record.getAudState())) {
					audit.setAudState("10113");
				}
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			
			if (rows>0) {
				return materialListMapper.updateByPrimaryKeySelective(record);
			} else {
				return 0;
			}
		} else {
			return materialListMapper.insertSelective(record);
		}
		
	}

	@Override
	public List<MaterialList> selectBydrugId(String id) { 
		return materialListMapper.selectBydrugId(id);
	}

}
