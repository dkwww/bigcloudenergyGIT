package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Provider;

public interface ProviderMapper {
	
	/**
	 * 根据id删除
	 * @param drugId 供应商id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
    int deleteByPrimaryKey(String provId);
    
    /**
    * 增加
    * @param record
    * @return int 处理的行数
    * @author ZhouJun
    */
    int insert(Provider record);

    /**
     * 动态增加
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */	
    int insertSelective(Provider record);
    
    /**
     * 根据id查询
     * @param dtId
     * @return Provider 供应商模型类
     * @author ZhouJun
     */
    Provider selectByPrimaryKey(String provId);
    
	/**
     * 根据id动态修改
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKeySelective(Provider record);
    
    /**
     * 根据id修改
     * @param record
     * @return int 处理的行数
     * @author ZhouJun
     */
    int updateByPrimaryKey(Provider record);
    
    /**
     * 条件查询所有
     * @param map 查询的数据
     * @return List<Provider> 供应商数据
     * @author ZhouJun
     */
	List<Provider> selectBySelective(Map<String, Object> map);
	
	/**
	 * 获得条件查询所有的总行数
	 * @param record
	 * @return
	 * @author ZhouJun
	 */
	int selectCountBySelective(Provider record);
	
	/**
	 * 批量删除
	 * @param ids 需要删除的id
	 * @return int 处理的行数
	 * @author ZhouJun
	 */
	int bulkDeleteByPrimaryKeySelective(List<String> ids);
	
	/**
     * 查询所有
     * @param map
     * @return
     */
    List<Provider> showList(Map<String, Object> map);
}