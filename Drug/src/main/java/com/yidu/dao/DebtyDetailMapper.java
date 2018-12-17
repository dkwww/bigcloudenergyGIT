package com.yidu.dao;

import java.util.List;
import java.util.Map;


import com.yidu.domain.DebtyDetail;
import com.yidu.util.PageUtil;

public interface DebtyDetailMapper {
    int deleteByPrimaryKey(String ddetId);

    int insert(DebtyDetail record);

    int insertSelective(DebtyDetail record);

    DebtyDetail selectByPrimaryKey(String ddetId);

    int updateByPrimaryKeySelective(DebtyDetail record);

    int updateByPrimaryKey(DebtyDetail record);
    
    /**
     * 根据财务id查询财务明细所有
     * @param map
     * @return
     */
    List<DebtyDetail> selectAll(Map<String, Object> map);
    
    
    
    int selectCount(DebtyDetail debty);
}