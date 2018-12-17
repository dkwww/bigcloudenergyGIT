package com.yidu.service;


import java.util.List;
import java.util.Map;

import com.yidu.domain.Audit;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 审核表 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface AuditService   {
	
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public List<Audit> showList(Audit audit,PageUtil pageUtil);
	
	/**
	 * 增加或修改的方法
	 * @param detail
	 * @return
	 */
	public int addOrUpdate(Audit audit);
	
	
	/**
	 * 修改
	 * @param toy
	 * @return
	 */
	public int updateByPrimaryKeySelective(Audit audit);
	
	/**
	 * 增加
	 * @param toy
	 * @return
	 */
	public int insertSelective(Audit audit);

	/**
	 * 查询总行数
	 * @param audit
	 * @return
	 */
	public int findCount(Audit audit);
	
	
}
