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
	 * 
	 * 方法说明：查询材料类型所有
	 * @param type 材料类对象
	 * @param pageUtil
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	List<MatType> showList(MatType type,PageUtil pageUtil);
	
	/**
	 * 
	 * 方法说明：查询材料类型总行数
	 * @param type 材料类对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	int selectCount(MatType type);
	
	/**
	 * 
	 * 方法说明：增加或修改
	 * @param type 材料类对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	int addorupdate(MatType type);
	
	
	
	
}
