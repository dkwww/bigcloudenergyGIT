package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Drug;

public interface DrugMapper {
	/**
	 * 根据id删除
	 * @param drugId 药品id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String drugId);
    
    /**
     * 增加
     * @param record 药品模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(Drug record);
    
    /**
     * 动态增加
     * @param record 药品模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(Drug record);
    
    /**
     * 根据id查询
     * @param drugId 药品id
     * @return Drug 药品模型类
     * @author ZhouJun
     */
    Drug selectByPrimaryKey(String drugId);
    
    /**
     * 根据id动态修改
     * @param record 药品模型类
     * @return int 处理的函数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(Drug record);
    
    /**
     * 根据id修改
     * @param record 药品模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(Drug record);
    
    /**
     * 条件查询药品
     * @param map 条件
     * @return List<Drug> 药品数据
     * @author ZhouJun
     */
    List<Drug> selectBySelective(Map<String, Object> map);
    
    /**
     * 获得条件查询药品的总行数
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int selectCountBySelective(Drug record);
    
    /**
     * 批量删除
     * @param ids id集合
     * @return int 处理的行数
     * @author ZhouJun
     */
	int bulkDeleteByPrimaryKeySelective(List<String> ids);
	
	/**
	 * 根据药品id查询药品是否完善并放回行数
	 * @param drugId
	 * @return
	 * @author ZhouJun
	 */
	int check(String drugId);
	
	/**
	 * 根据药品id查询审核状态
	 * @param drugId
	 * @return
	 * @author ZhouJun
	 */
	Drug isCheck(String drugId);
	
	
	/**
	 * 查询审核表有数据的药品
	 * @param map
	 * @return
	 * @author ZhouJun
	 */
	List<Drug> selectByAudit(Map<String, Object> map);
	
	/**
	 * 获得查询审核表有数据的药品的总行数
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int selectAuditCount(Drug record);
	
	/**
	 * 查询已审核的药品
	 * @param map
	 * @return
	 * @author ZhouJun
	 */
	List<Drug> findChecked(Map<String, Object> map);
	
	/**
	 * 获得查询已审核的药品的行数
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int findCheckedCount(Drug record);
}