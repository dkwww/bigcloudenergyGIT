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
	 * 查询所有
	 * @param material
	 * @return
	 */
	List<Material> showList(Material material,PageUtil page);
	
	int selectCount(Material mat);
	
	
	int addorUpdate(Material mat);
	
}
