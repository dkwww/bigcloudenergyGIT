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
    
    /**
     * 
     * 方法说明： 根据质检id查看质检明细
     * @param map map对象
     * @return
     * @author dengkangwei
     * @date：2019年1月8日
     */
    List<QcDetail> findByIds(Map<String, Object> map);
    
    /**
     * 根据质检id查看质检明细
     * @param qcId 质检id
     * @author dengkangwei
     * @return
     */
    List<QcDetail> findkcId(String qcId);
    
    
    /**
     * 
     * 方法说明：根据质检id查看质检明细总行数
     * @param qcdetail
     * @return
     * @author dengkangwei
     * @date：2019年1月5日
     */
    int findByIdselectCount(QcDetail qcdetail);
    
    
    List<QcDetail>   selectbyId (Map<String, Object> map);
    
    
     int    selectbycount  (QcDetail  qcDetail);
     
    List<QcDetail> selectQcId (String  id);

	List<QcDetail> findByIdss(String qcId);

	List<QcDetail> findByQcId(String id);
}