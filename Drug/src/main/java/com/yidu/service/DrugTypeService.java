package com.yidu.service;

import java.util.List;

import com.yidu.domain.DrugType;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 药品类型 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface DrugTypeService   {

	List<DrugType> showList();

	List<DrugType> findAll(DrugType record, PageUtil pageUtil);

	int findCount(DrugType record);

	int addOrUpdate(DrugType record);

	int bulkUpdate(List<String> ids);

}
