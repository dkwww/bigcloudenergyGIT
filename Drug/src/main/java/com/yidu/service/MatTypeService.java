package com.yidu.service;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MatType;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原材料类型 服务类
 * </p>
 *
 * @author 邓康威
 * @since 2018-11-26
 */
public interface MatTypeService  {
	
	/**
	 * 查询所有
	 * @return
	 */
	List<MatType> showList(MatType type,PageUtil pageUtil);
	
	
	int selectCount(MatType type);
	
	/**
	 * 增加或修改
	 * @param type
	 * @return
	 */
	int addorupdate(MatType type);
	
	
	int delete(String mtId);
	
	
	MatType showUpdate(String mtId);
	
	
	
}
