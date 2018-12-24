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
	 * @param audit
	 * @return
	 */
	public int updateByPrimaryKeySelective(Audit audit);
	
	/**
	 * 增加
	 * @param audit
	 * @return
	 */
	public int insertSelective(Audit audit);

	/**
	 * 查询总行数
	 * @param audit
	 * @return
	 */
	public int findCount(Audit audit);
	
	/**
	 * 查询所有
	 * @param audit
	 * @param pageUtil
	 * @author 邓康威
	 * @return
	 */
	List<Audit> bushowList(Audit audit,PageUtil pageUtil);
	
	/**
	 * 查询总行数
	 * @param audit
	 * @author 邓康威
	 * @return
	 */
	int selectCount(Audit audit);
	
	/**
	 * 增加
	 * @param audit
	 * @author 邓康威
	 * @return
	 */
	int add(Audit audit);
	
	
	/**
	 * 显示批发总经理审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> wholeceo(Audit audit,PageUtil pageUtil);
	
	/**
	 * 修改状态为29
	 * @param audId
	 * @return
	 */
	public int wholeceoupdate(String audId);
	
	
	/**
	 * 显示批发财务审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> financeo(Audit audit,PageUtil pageUtil);
	
	
	/**
	 * 修改状态为30
	 * @param audId
	 * @return
	 */
	public int finanupdate(String audId);
	
	/**
	 * 显示总店财务审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> findSale(Audit audit,PageUtil pageUtil);
	
	/**
	 * 显示总店总经理审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> findCEO(Audit audit,PageUtil pageUtil);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Audit findById(String audId);
	
	
	/**
	 * 显示分店财务审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> showBuy(Audit audit,PageUtil pageUtil);
	
	/**
	 * 显示分店总经理审核
	 * @param audit
	 * @param pageUtil
	 * @return
	 */
	public List<Audit> showCEO(Audit audit,PageUtil pageUtil);
	
}
