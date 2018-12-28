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
    
    /**
     * 分店质检查询所有
     * @param map
     * @return
     */
    List<Qc>  branchQuality(Map<String, Object> map);
    
    /**
     * 材料查询所有
     * @param map
     * @author 邓康威
     * @return
     */
    List<Qc>  showList(Map<String, Object> map);
    
    /**
     * 查看总行数
     * @param qc
     * @author 邓康威
     * @return
     */
    int selectCount(Qc qc);
    
    List<Qc> findById(String qcId);
}

