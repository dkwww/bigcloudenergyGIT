package com.yidu.service.impl;

 
import java.util.ArrayList;
import java.util.Date;
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
	private DrugMapper drugMapper;//注入药品导类
	@Resource
	private AuditMapper auditMapper;//注入审核导类
	@Resource
	private DrugInveMapper drugInveMapper;//注入药品库存导类

	@Override
	public List<Drug> findAll(Drug record, PageUtil pageUtil) {
		//获得map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		
		//条件查询数据
		List<Drug> list = drugMapper.selectBySelective(map);
		//获得一个list集合
		List<Drug> lists = new ArrayList<Drug>();
		//循环遍历
		for (Drug drug : list) {
			//查询审核状态
			Drug drugs = drugMapper.isCheck(drug.getDrugId());
			//判断是否为空
			if (drugs!=null) {
				//审核状态赋值
				drug.setAudState(drugs.getAudState());
				//审核id赋值
				drug.setAudId(drugs.getAudId());
			} else {
				//审核状态赋值
				drug.setAudState("-1");
			}
			//将数据添加到新的集合
			lists.add(drug);
		}
		//返回集合
		return lists;
	}

	@Override
	public int addOrUpdate(Drug record) {
		//操作时间赋值
		record.setOptime(new Date());
		//判断药品id是否为空
		if (record.getDrugId()!=null&&!"".equals(record.getDrugId())) {
			//初始化局部变量
			int rows = 1;
			//判断审核状态
			if (!"-1".equals(record.getAudState()) && !"10112".equals(record.getAudState()) && !"10113".equals(record.getAudState()) && record.getAudState()!=null && !"".equals(record.getAudState())) {
				//获得审核模型类
				Audit audit = new Audit();
				//审核id赋值
				audit.setAudId(record.getAudId());
				//如果审核状态为审核失败
				if ("10110".equals(record.getAudState())) {
					//审核状态赋值
					audit.setAudState("10112");
				//如果审核状态为审核成功
				} else if ("10111".equals(record.getAudState())) {
					//审核状态赋值
					audit.setAudState("10113");
				} else {
					//审核状态赋值
					audit.setAudState(record.getAudState());
				}
				//修改审核数据
				rows = auditMapper.updateByPrimaryKeySelective(audit);
			}
			//如果审核修改或增加成功
			if (rows>0) {
				//修改药品数据
				return drugMapper.updateByPrimaryKeySelective(record);
			} else {
				//放回0
				return 0;
			}
		} else {
			//药品有效状态赋值
			record.setIsva("1");
			//药品排序赋值当前操作时间
			record.setSort(TimeUtil.getStrDate());
			//增加药品
			drugMapper.insertSelective(record);
			//获得药品库存对象
			DrugInve drugInve = new DrugInve();
			//药品库存id赋值
			drugInve.setDiId(UUID.randomUUID().toString().replace("-", ""));
			//库存公司id赋值
			drugInve.setComId(record.getComId());
			//库存数量赋值
			drugInve.setDiAmount(0);
			//库存有效状态赋值
			drugInve.setIsva("1");
			//库存药品id赋值
			drugInve.setDrugId(record.getDrugId());
			//增加药品库存
			int row = drugInveMapper.insert(drugInve);
			//放回修改的行数
			return row;
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		//进行批量删除并返回行数
		return drugMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

	@Override
	public int findCount(Drug record) {
		//获得条件查询的总行数
		return drugMapper.selectCountBySelective(record);
	}

	@Override
	public int check(String drugId) {
		//根据药品id查询并放回行数
		return drugMapper.check(drugId);
	}

	@Override
	public List<Drug> showAudit(Drug record, PageUtil pageUtil) {
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//查询审核表的药品
		List<Drug> list = drugMapper.selectByAudit(map);
		//集合去重复
		for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).getDrugId().equals(list.get(i).getDrugId())) {
                    list.remove(j);
                }
            }
        }
		//返回集合
		return list;
	}

	@Override
	public int findAuditCount(Drug record) {
		//获得审核表的药品总行数
		return drugMapper.selectAuditCount(record);
	}

	@Override
	public List<Drug> findChecked(Drug record, PageUtil pageUtil) {
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//查询已审核的药品并返回数据
		return drugMapper.findChecked(map);
	}

	@Override
	public int findCheckedCount(Drug record) {
		//查询已审核的药品并返回总行数
		return drugMapper.findCheckedCount(record);
	}
}
