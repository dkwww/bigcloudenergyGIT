package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MaterialList;

public interface MaterialListMapper {
	/**
	 * 根据id删除
	 * @param drugId 物料清单id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String mlId);
    
    /**
     * 增加
     * @param record 物料清单模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insert(MaterialList record);
    
    /**
     * 动态增加
     * @param record 物料清单模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int insertSelective(MaterialList record);
    
    /**
     * 根据id查询
     * @param drugId 物料清单id
     * @return Drug 物料清单模型类
     * @author ZhouJun
     */
    MaterialList selectByPrimaryKey(String mlId);
    
    /**
     * 根据id动态修改
     * @param record 物料清单模型类
     * @return int 处理的函数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(MaterialList record);
    
    /**
     * 根据id修改
     * @param record 物料清单模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(MaterialList record);
    
    /**
     * 条件查询物料清单
     * @param map 条件
     * @return List<MaterialList> 物料清单数据
     * @author ZhouJun
     */
	List<MaterialList> selectBySelective(Map<String, Object> map);
	
	 /**
     * 获得条件查询药品的总行数
     * @param record 物料清单模型类
     * @return int 处理的行数
     * @author ZhouJun
     */
	int selectCountBySelective(MaterialList record);
	
	/**
	 * 根据药品id查询物料清单
	 * @param id 药品id
	 * @return List<MaterialList> 物料清单数据
	 * @author ZhouJun
	 */
	List<MaterialList> selectByDrug(String drugId);
}