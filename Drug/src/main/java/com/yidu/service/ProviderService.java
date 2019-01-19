package com.yidu.service;

import java.util.List;

import com.yidu.domain.Provider;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 原料供应商 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface ProviderService   {
	
	List<Provider> showList(Provider pro);

	/**
	 * 条件查询供应商数据
	 * @param record 供应商模型类
	 * @param pageUtil 分页工具类
	 * @return List<Provider> 供应商数据
	 * @author ZhouJun
	 */
	List<Provider> findAll(Provider record, PageUtil pageUtil);
	
	/**
	 * 条件查询供应商总行数
	 * @param record 供应商模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findCount(Provider record);
	
	/**
	 * 增加或修改
	 * @param record 供应商数据
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int addOrUpdate(Provider record);
	
	/**
	 * 批量删除
	 * @param ids 需要删除的id
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int bulkUpdate(List<String> ids);
}
