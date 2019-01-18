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
	
	/**
	 * 条件查询物料清单
	 * @param record 物料清单模型类
	 * @param pageUtil 分页工具类
	 * @return List<MaterialList> 物料清单数据
	 * @author ZhouJun
	 */
	List<MaterialList> findAll(MaterialList record, PageUtil pageUtil);
	
	/**
	 * 条件查询物料清单的总行数
	 * @param record 物料清单模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findCount(MaterialList record);
	
	/**
	 * 增加或修改
	 * @param record 物料清单模型类
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int addOrUpdate(MaterialList record);
}
