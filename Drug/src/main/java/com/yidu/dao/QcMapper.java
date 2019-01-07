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
     * @author dengkangwei
     * @return
     */
    List<Qc>  showList(Map<String, Object> map);
    
    /**
     * 查看总行数
     * @param qc
     * @author dengkangwei
     * @return
     */
    int selectCount(Qc qc);
    
    /**
     * 
     * 方法说明：根据质检id查询质检、质检明细
     * @param qcId
     * @return
     * @author dengkangwei
     * @date：2019年1月7日
     */
    List<Qc> findById(String qcId);
}

