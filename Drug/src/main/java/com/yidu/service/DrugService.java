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
	//检查
	int checked(String drugId);
	//查询所有附加库存
	List<Drug> selectBySelectives(Drug record, PageUtil pageUtil);
	//显示审核列表
	List<Drug> showAudit(Drug record, PageUtil pageUtil);
	//获得审核列表总行数
	int findAuditCount(Drug record);

}
