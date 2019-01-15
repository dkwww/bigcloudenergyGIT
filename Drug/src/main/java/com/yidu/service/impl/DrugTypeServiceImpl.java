package com.yidu.service.impl;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.DrugTypeMapper;
import com.yidu.domain.DrugType;
import com.yidu.service.DrugTypeService;
import com.yidu.util.PageUtil;
import com.yidu.util.TimeUtil;

/**
 * <p>
 * 药品类型 服务实现类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
@Service
public class DrugTypeServiceImpl  implements DrugTypeService {
	
	@Resource
	private DrugTypeMapper drugTypeMapper;//注入药品类型导类

	@Override
	public List<DrugType> showList() {
		//查询所有并返回数据
		return drugTypeMapper.selectList();
	}

	@Override
	public List<DrugType> findAll(DrugType record, PageUtil pageUtil) {
		//获得一个map对象并赋值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("pageUtil", pageUtil);
		//条件查询所有并返回
		return drugTypeMapper.selectBySelective(map);
	}

	@Override
	public int findCount(DrugType record) {
		//获得条件查询所有的总行数并返回
		return drugTypeMapper.selectCountBySelective(record);
	}

	@Override
	public int addOrUpdate(DrugType record) {
		//如果药品类型的id不为空
		if (record.getDtId()!=null && !"".equals(record.getDtId())) {
			//进行修改并返回修改的行数
			return drugTypeMapper.updateByPrimaryKeySelective(record);
		} else {
			//药品赋值有效
			record.setIsva("1");
			//排序赋值
			record.setSort(TimeUtil.getStrDate());
			//操作时间赋值
			record.setOptime(new Date());
			//进行增加并返回增加的行数
			return drugTypeMapper.insertSelective(record);
		}
	}

	@Override
	public int bulkUpdate(List<String> ids) {
		//批量删除并返回修改的行数
		return drugTypeMapper.bulkDeleteByPrimaryKeySelective(ids);
	}

}
