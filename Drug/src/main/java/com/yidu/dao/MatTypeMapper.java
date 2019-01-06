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
     * 
     * 方法说明：查询所有
     * @param map map对象
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
    List<MatType> showList(Map<String, Object> map);
    
    /**
     * 
     * 方法说明：查询总行数
     * @param type 对象
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
    int selectCount(MatType type);
    
    
    
    
}