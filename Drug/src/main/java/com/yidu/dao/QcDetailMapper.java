 package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.QcDetail;

public interface QcDetailMapper {
    int deleteByPrimaryKey(String qdetId);

    int insert(QcDetail record);

    int insertSelective(QcDetail record);

    QcDetail selectByPrimaryKey(String qdetId);

    int updateByPrimaryKeySelective(QcDetail record);

    int updateByPrimaryKey(QcDetail record);
    
    List<QcDetail> findById(Map<String, Object> map);
    
    List<QcDetail> findByIds(String qcId);
    
    
    List<QcDetail>   selectbyId (Map<String, Object> map);
    
    
     int    selectbycount  (QcDetail  qcDetail);
}