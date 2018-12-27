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
    
    /**
     * 查询总行数
     * @param type
     * @return
     */
    int selectCount(MatType type);
    
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int TypeupdateByPrimaryKeySelective(List<String> ids);
    
    
}