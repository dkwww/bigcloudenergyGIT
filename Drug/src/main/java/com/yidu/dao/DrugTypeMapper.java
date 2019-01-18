package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.DrugType;

public interface DrugTypeMapper {
	/**
	 * 根据id删除
	 * @param drugId 药品id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String dtId);
    
    /**
     * 增加
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(DrugType record);
    
    /**
     * 动态增加
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(DrugType record);
    
    /**
     * 根据id查询
     * @param dtId
     * @return DrugType 药品类型模型类
     * @author ZhouJun
     */
    DrugType selectByPrimaryKey(String dtId);
    
    /**
     * 根据id动态修改
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(DrugType record);
    
    /**
     * 根据id修改
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(DrugType record);
    
    /**
     * 查询所有的数据
     * @return List<DrugType> 药品数据
     * @author ZhouJun
     */
    List<DrugType> selectList();
    
    /**
     * 条件查询所有
     * @param map 查询的数据
     * @return List<DrugType> 药品数据
     * @author ZhouJun
     */
	List<DrugType> selectBySelective(Map<String, Object> map);
	
	/**
	 * 获得条件查询所有的总行数
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int selectCountBySelective(DrugType record);
	
	/**
	 * 批量删除
	 * @param ids 需要删除的id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
	int bulkDeleteByPrimaryKeySelective(List<String> ids);
}