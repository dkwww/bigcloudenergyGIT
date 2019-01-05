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
     * 
     * 方法说明：查询原材料所有
     * @param map map对象
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
    List<Material> showList(Map<String, Object> map);
    
    /**
     * 
     * 方法说明：查询总行数
     * @param mat 原材料对象
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
    int selectCount(Material mat);
}