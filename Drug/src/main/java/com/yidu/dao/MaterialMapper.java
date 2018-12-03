package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String matId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String matId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
    
    
    /**
     * 查询所有
     * @param material
     * @return
     */
    List<Material> showList(Map<String, Object> map);
    
    
    int selectCount(Material mat);
}