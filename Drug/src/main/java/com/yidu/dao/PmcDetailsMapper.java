package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.PmcDetails;

public interface PmcDetailsMapper {
	/**
	 * 根据id删除
	 * @param pdId 生产明细id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String pdId);
    
    /**
     * 增加
     * @param record 生产明细模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(PmcDetails record);
    
    /**
     * 动态增加
     * @param record 生产明细模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(PmcDetails record);
    
    /**
     * 根据id查询
     * @param pdId 生产明细id
     * @return Drug 生产明细模型类
     * @author ZhouJun
     */
    PmcDetails selectByPrimaryKey(String pdId);
    
    /**
     * 根据id动态修改
     * @param record 生产明细模型类
     * @return int 处理的函数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(PmcDetails record);
    
    /**
     * 根据id修改
     * @param record 生产明细模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(PmcDetails record);
    
    /**
     * 条件查询生产明细
     * @param map 条件
     * @return List<Drug> 生产明细数据
     * @author ZhouJun
     */
    List<PmcDetails> selectBySelective(Map<String , Object> map);
    
    /**
     * 获得条件查询生产明细的总行数
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int selectCountBySelective (PmcDetails record);
    
    /**
     * 根据生产计划查询生产明细
     * @param id 生产计划id
     * @return List<PmcDetails> 生产明细数据
     * @author ZhouJun
     */
    List<PmcDetails> selectPmcId(String id);
    
    /**
     * 根据药品id查询原材料库存
     * @param drugId
     * @return
     * @author ZhouJun
     */
    List<PmcDetails> selectMatInv(String drugId);
    
} 