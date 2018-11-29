package com.yidu.service;

import java.util.List;

import com.yidu.domain.Drug;

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
	List<Drug> findAll(Drug record);
	//增加药品
	int addOrUpdate(Drug record);
	//批量修改
	int bulkUpdate(String[] ids);

}
