package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.domain.MatInvDetail;

public interface MatInvDetailMapper {
    int deleteByPrimaryKey(String midId);

    int insert(MatInvDetail record);

    int insertSelective(MatInvDetail record);

    MatInvDetail selectByPrimaryKey(String midId);

    int updateByPrimaryKeySelective(MatInvDetail record);

    int updateByPrimaryKey(MatInvDetail record);
    
    /**
     * 
     * 方法说明：根据库存id查询库存明细
     * @param matdetail
     * @return
     * @author dengknagwei
     * @date：2018年12月27日
     */
    List<MatInvDetail> findById(Map<String, Object> map);
    
    /**
     * 
     * 方法说明：查询总行数
     * @param matdetail
     * @return
     * @author dengknagwei
     * @date：2018年12月27日
     */
    int selectCount(MatInvDetail matdetail);
}