package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Pmc;

public interface PmcMapper {
	/**
	 * 根据id删除
	 * @param pmcId 生产计划id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String pmcId);
    
    /**
     * 增加
     * @param record 生产计划模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(Pmc record);
    
    /**
     * 动态增加
     * @param record 生产计划模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(Pmc record);
    
    /**
     * 根据id查询
     * @param pmcId 生产计划id
     * @return Pmc 药品模型类
     * @author ZhouJun
     */
    Pmc selectByPrimaryKey(String pmcId);
    
    /**
     * 根据id动态修改
     * @param record 药品模型类
     * @return int 处理的函数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(Pmc record);
    
    /**
     * 根据id修改
     * @param record 药品模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(Pmc record);
    
    /**
     * 条件查询生产计划
     * @param map 条件
     * @return List<Drug> 药品数据
     * @author ZhouJun
     */
	List<Pmc> selectBySelective(Map<String, Object> map);
	
	/**
     * 获得条件查询生产计划的总行数
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
	int selectCountBySelective(Pmc record);
	
	/**
     * 批量删除
     * @param ids id集合
     * @return int 处理的行数
     * @author ZhouJun
     */
	int bulkDeleteByPrimaryKeySelective(List<String> ids);
	
	/**
	 * 根据药品id查询药品是否完善并放回行数
	 * @param pmcId 生产计划id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
	int check(String pmcId);
	
	/**
	 * 根据生产计划id查询审核状态
	 * @param pmcId 生产计划id
	 * @return String 审核状态
	 * @author ZhouJun
	 */
	String isCheck(String pmcId);  
	
	/**
	 * 根据id查询
	 * @param pmcId 生产计划id
	 * @return Pmc 生产计划模型类
	 * @author ZhouJun
	 */
	Pmc selectById(String pmcId);
	
	/**
	 * 查询审核表有数据的药品
	 * @param map 查询的参数
	 * @return List<Pmc> 生产计划模型类
	 * @author ZhouJun
	 */
	List<Pmc> selectByAudit(Map<String, Object> map);
	
	/**
	 * 获得查询审核表有数据的药品的总行数
	 * @param record 生产计划模型类
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
	int selectAuditCount(Pmc record);
	
	/**
	 * 根据生产计划id查询财务审核的数据
	 * @param pmcId 生产计划id
	 * @return Pmc 生产计划模型类
	 * @author ZhouJun
	 */
	Pmc selectByPpt(String pmcId);
	
	/**
	 * 根据审核id查询物料明细
	 * @param audId 审核id
	 * @return Pmc 生产计划模型类
	 * @author ZhouJun
	 */
	Pmc selectByAuditId(String audId);
}