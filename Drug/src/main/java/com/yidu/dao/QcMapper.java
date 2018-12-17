package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.Qc;

public interface QcMapper {
    int deleteByPrimaryKey(String qcId);

    int insert(Qc record);

    int insertSelective(Qc record);

    Qc selectByPrimaryKey(String qcId);

    int updateByPrimaryKeySelective(Qc record);

    int updateByPrimaryKey(Qc record);
    
    
    List<Qc>  selectqctype(Map<String, Object> map);
    
    int selectCountBySelective(Qc record);
}

