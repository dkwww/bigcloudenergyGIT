package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.AuditMapper;
import com.yidu.dao.DrugInveMapper;
import com.yidu.dao.DrugMapper;
import com.yidu.domain.Audit;
import com.yidu.domain.Drug;
import com.yidu.domain.DrugInve;
import com.yidu.service.DrugService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 药品表 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugServiceImpl implements DrugService {
	
	@Resource
	private DrugMapper drugMapper;
	@Resource
	private AuditMapper auditMapper;
	@Resource
	private DrugInveMapper drugInveMapper;

	@Override
	public List<Drug> findAll(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<Drug> list = drugMapper.selectBySelective(map);
		List<Drug> lists = new ArrayList<Drug>();
		for (Drug drug : list) {
			Drug drugs = drugMapper.isCheck(drug.getDrugId());
			if (drugs!=null) {
				drug.setAudState(drugs.getAudState());
				drug.setAudId(drugs.getAudId());
			} else {
				drug.setAudState("-1");
			}
			lists.add(drug);
		}
		return lists;
	}

	@Override
	public int addOrUpdate(Drug record) {
		if (record.getDrugId()!=null&&!"".equals(record.getDrugId())) {
			int rows = 1;
			if (!"-1".equals(record.getAudState()) && !"10112".equals(record.getAudState()) && !"10113".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				Audit audit = new Audit();
				audit.setAudId(record.getAudId());
				if ("10110".equals(record.getAudState())) {
					audit.setAudState("10112");
				} else if ("10111".equals(record.getAudState())) {
					audit.setAudState("10113");
				} else {
					audit.setAudState(record.getAudState());
				}
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			
			if (rows>0) {
				return drugMapper.updateByPrimaryKeySelective(record);
			} else {
				return 0;
			}
		} else {
			record.setIsva("1");
			record.setSort(TimeUtil.getStrDate());
			DrugInve drugInve = new DrugInve();
			drugInve.setDiId(UUID.randomUUID().toString().replace("-", ""));
			drugInve.setComId(record.getComId());
			drugInve.setDiAmount(0);
			drugInve.setIsva("1");
			drugMapper.insertSelective(record);
			drugInve.setDrugId(record.getDrugId());
			int row = drugInveMapper.insert(drugInve);
			return row;
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		return drugMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	@Override
	public int findCount(Drug record) {
		return drugMapper.selectCountBySelective(record);
	}

	@Override
	public int check(String drugId) {
		return drugMapper.check(drugId);
	}
	
	@Override
	public List<Drug> selectBySelectives(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugMapper.selectBySelective(map);
	}

	@Override
	public List<Drug> showAudit(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		List<Drug> list = drugMapper.selectByAudit(map);
		for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).getDrugId().equals(list.get(i).getDrugId())) {
                    list.remove(j);
                }
            }
        }
		return list;
	}

	@Override
	public int findAuditCount(Drug record) {
		return drugMapper.selectAuditCount(record);
	}

	@Override
	public List<Drug> findChecked(Drug record, PageUtil pageUtil) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		return drugMapper.findChecked(map);
	}

	@Override
	public int findCheckedCount(Drug record) {
		return drugMapper.findCheckedCount(record);
	}
}
