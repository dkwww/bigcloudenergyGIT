package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Wholesale;
import com.yidu.domain.WholesaleDetail;

public interface WholesaleDetailMapper {
    int deleteByPrimaryKey(String wdId);

    int insert(WholesaleDetail record);

    int insertSelective(WholesaleDetail record);

    WholesaleDetail selectByPrimaryKey(String wdId);

    int updateByPrimaryKeySelective(WholesaleDetail record);

    int updateByPrimaryKey(WholesaleDetail record);
    
    public List<WholesaleDetail> selectdetaiM(Map<String, Object> map);
    
    public int selectCount(Map<String, Object> map);
}