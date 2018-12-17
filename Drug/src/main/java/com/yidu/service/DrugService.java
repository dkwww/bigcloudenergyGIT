package com.yidu.service;

import java.util.List;

import com.yidu.domain.Drug;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 药品表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface DrugService   {
	
	//查询所有
	List<Drug> findAll(Drug record, PageUtil pageUtil);
	//增加药品
	int addOrUpdate(Drug record);
	//批量修改
	int bulkUpdate(List<String> ids);
	//查找总行数
	int findCount(Drug record);
	//根据药品编号多表查询
	int isCheck(String drugId);
	//添加到审核表
	int addCheck(String drugId);

}
