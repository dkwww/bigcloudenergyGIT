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
	
	/**
	 * 查询所有
	 * @param record 药品模型类
	 * @param pageUtil 分页工具类
	 * @return List<Drug> 药品数据
	 * @author ZhouJun
	 */
	List<Drug> findAll(Drug record, PageUtil pageUtil);
	
	/**
	 * 增加药品
	 * @param record 药品模型类
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int addOrUpdate(Drug record);
	
	/**
	 * 批量修改
	 * @param ids 要删除的id
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int bulkUpdate(List<String> ids);
	
	/**
	 * 查找总行数
	 * @param record 药品模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findCount(Drug record);
	
	/**
	 * 根据药品编号多表查询
	 * @param comId 公司id
	 * @return int 查询出的行数
	 * @author ZhouJun
	 */
	int check(String comId);
	
	/**
	 * 显示审核列表数据
	 * @param record 药品模型类
	 * @param pageUtil 分页工具类
	 * @return List<Drug> 药品数据
	 * @author ZhouJun
	 */
	List<Drug> showAudit(Drug record, PageUtil pageUtil);
	
	/**
	 * 获得审核列表总行数
	 * @param record 药品模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findAuditCount(Drug record);
	
	/**
	 * 查找审核通过后的药品
	 * @param record 药品模型类
	 * @param pageUtil 分页工具类
	 * @return List<Drug> 药品数据
	 * @author ZhouJun
	 */
	List<Drug> findChecked(Drug record, PageUtil pageUtil);
	
	/**
	 * 查找审核通过后的总行数
	 * @param record 药品模型
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findCheckedCount(Drug record);
}
