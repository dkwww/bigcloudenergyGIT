package com.yidu.service;

import java.util.List;

import com.yidu.domain.MaterialList;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 物料清单 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MaterialListService   {

	List<MaterialList> findAll(MaterialList record, PageUtil pageUtil);

	int findCount(MaterialList record);

	int addOrUpdate(MaterialList record);
	
	
	List<MaterialList> selectBydrugId (String   id);

}
