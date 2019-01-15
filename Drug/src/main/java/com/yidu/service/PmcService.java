package com.yidu.service;

import java.util.List;

import com.yidu.domain.Pmc;
import com.yidu.util.PageUtil;

/**
 * <p>
 * 生产计划单 服务类
 * </p>
 *
 * @author Pngjiangping
 * @since 2018-11-26
 */
public interface PmcService  {
	
	/**
	 * 条件查询生产计划
	 * @param record 生产计划模型类
	 * @param pageUtil 分页工具类
	 * @return List<Pmc> 生产计划数据
	 * @author ZhouJun
	 */
	List<Pmc> findAll(Pmc record, PageUtil pageUtil);
	
	/**
	 * 条件查询生产计划的总行数
	 * @param record 生产计划总行数
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int findCount(Pmc record);
	
	/**
	 * 增加或修改
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int addOrUpdate(Pmc record);
	
	/**
	 * 批量删除
	 * @param ids 需要删除的id
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int bulkUpdate(List<String> ids);
	
	/**
	 * 根据生产计划查询生产明细
	 * @param pmcId 生产计划id
	 * @return int 查询的行数
	 * @author ZhouJun
	 */
	int check(String pmcId);
	
	/**
	 * 根据生产计划id查询
	 * @param pmcId 生产计划
	 * @return Pmc 生产计划模型类 
	 * @author ZhouJun
	 */
	Pmc selectById(String pmcId);
	
	/**
	 * 查询审核表的生产计划
	 * @param record 
	 * @param pageUtil 
	 * @return
	 * @author ZhouJun
	 */
	List<Pmc> showAudit(Pmc record, PageUtil pageUtil);
	
	/**
	 * 查询审核表的生产计划的行数
	 * @param record 生产计划模型类
	 * @return int 总行数
	 * @author ZhouJun
	 */
	int findAuditCount(Pmc record);
	
	/**
	 * 加入制造计划
	 * @param record 生产计划模型类
	 * @return int 修改的行数
	 * @author ZhouJun
	 */
	int joinMade(Pmc record);

}
