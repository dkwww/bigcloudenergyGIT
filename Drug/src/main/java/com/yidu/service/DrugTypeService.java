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
	
	/**
	 * 查询所有类型
	 * @return 类型数据
	 * @author ZhouJun
	 */
	List<DrugType> showList();
	
	/**
	 * 条件查询类型数据
	 * @param record 类型模型类
	 * @param pageUtil 分页工具类
	 * @return List<DrugType> 药品类型数据
	 * @author ZhouJun
	 */
	List<DrugType> findAll(DrugType record, PageUtil pageUtil);
	
	/**
	 * 条件查询类型总行数
	 * @param record 药品类型模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findCount(DrugType record);
	
	/**
	 * 增加或修改
	 * @param record 药品类型数据
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int addOrUpdate(DrugType record);
	
	/**
	 * 批量删除
	 * @param ids 需要删除的id
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int bulkUpdate(List<String> ids);

}
