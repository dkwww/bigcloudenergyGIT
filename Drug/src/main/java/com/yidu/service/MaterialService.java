package com.yidu.service;

import java.util.List;

import com.yidu.domain.Material;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原材料 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface MaterialService   {
	
	/**
	 * 
	 * 方法说明：查询原材料所有
	 * @param material 原材料对象
	 * @param page	页数
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	List<Material> showList(Material material,PageUtil page);
	
	/**
	 * 
	 * 方法说明：查询原材料总行数
	 * @param mat 原材料对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	int selectCount(Material mat);
	
	/**
	 * 
	 * 方法说明：增加或修改
	 * @param mat 原材料对象
	 * @return
	 * @author dengkangwei
	 * @date：2019年1月5日
	 */
	int addorUpdate(Material mat);
	
}
