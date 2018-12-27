package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.PmcDetails;

public interface PmcDetailsMapper {
    int deleteByPrimaryKey(String pdId);

    int insert(PmcDetails record);

    int insertSelective(PmcDetails record);

    PmcDetails selectByPrimaryKey(String pdId);

    int updateByPrimaryKeySelective(PmcDetails record);

    int updateByPrimaryKey(PmcDetails record);
    
    int selectCountBySelective (PmcDetails record);
    
    List<PmcDetails> selectBySelective(Map<String , Object> map);
    
    List<PmcDetails> selectPmcId(String id);
    
    List<PmcDetails> selectMatInv(String drugId);
    
} 