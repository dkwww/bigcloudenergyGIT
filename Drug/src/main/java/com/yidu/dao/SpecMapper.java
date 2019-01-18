package com.yidu.dao;

import com.yidu.domain.Spec;

public interface SpecMapper {
	/**
	 * 根据id删除
	 * @param specId 说明书id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String specId);
    
    /**
     * 增加
     * @param record 说明书模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(Spec record);
    
    /**
     * 动态增加
     * @param record 说明书模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(Spec record);
    
    /**
     * 根据id删除
     * @param specId 说明书id
     * @return Spec 说明书模型类
     * @author ZhouJun
     */
    Spec selectByPrimaryKey(String specId);
    
    /**
     * 根据id动态修改
     * @param record 说明书模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(Spec record);
    
    /**
     * 根据id修改
     * @param record 说明书模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(Spec record);
}