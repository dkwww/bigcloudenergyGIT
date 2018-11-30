package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MatType;

public interface MatTypeMapper {
    int deleteByPrimaryKey(String mtId);

    int insert(MatType record);

    int insertSelective(MatType record);

    MatType selectByPrimaryKey(String mtId);

    int updateByPrimaryKeySelective(MatType record);

    int updateByPrimaryKey(MatType record);
    
    /**
     * 查询所有
     * @return
     */
    List<MatType> showList(Map<String, Object> map);
    
    
    int selectCount(MatType type);
    
    
}