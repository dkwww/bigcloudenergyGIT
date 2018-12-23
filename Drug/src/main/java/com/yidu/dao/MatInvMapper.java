package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MatInv;

public interface MatInvMapper {
    int deleteByPrimaryKey(String miId);

    int insert(MatInv record);

    int insertSelective(MatInv record);

    MatInv selectByPrimaryKey(String miId);

    int updateByPrimaryKeySelective(MatInv record);

    int updateByPrimaryKey(MatInv record);
    
    
    /**
     * 查询所有
     * @param map
     * @return
     */
    List<MatInv> showList(Map<String, Object> map);
    
    /**
     * 查询总行数
     * @param matinv
     * @return
     */
    int selectCount(MatInv matinv);
}